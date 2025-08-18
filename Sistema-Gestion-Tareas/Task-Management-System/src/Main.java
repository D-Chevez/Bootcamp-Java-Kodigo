import model.*;
import repository.inmem.InMemoryProjectRepository;
import repository.inmem.InMemoryTaskRepository;
import repository.inmem.InMemoryUserRepository;
import service.*;
import service.filter.TaskFilter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    private final Scanner in = new Scanner(System.in);
    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;

    public Main() {
        // DI manual con repos In-Memory
        var userRepo = new InMemoryUserRepository();
        var projRepo = new InMemoryProjectRepository();
        var taskRepo = new InMemoryTaskRepository();

        this.userService = new UserServiceImp(userRepo);
        this.projectService = new ProjectServiceImp(projRepo);
        this.taskService = new TaskServiceImp(taskRepo);
    }

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        boolean running = true;
        while (running) {
            printMenu();
            String opt = prompt("Selecciona una opción");
            switch (opt) {
                case "1" -> createUser();
                case "2" -> listUsers();
                case "3" -> createProject();
                case "4" -> listProjects();
                case "5" -> createTask();
                case "6" -> listTasks();
                case "7" -> assignTaskToUser();
                case "8" -> changeTaskStatus();
                case "9" -> filterTasks();
                case "10" -> deleteTask();
                case "0" -> {
                    System.out.println("Saliendo... ¡Gracias!");
                    running = false;
                }
                default -> System.out.println("Opción inválida.");
            }
            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println("======================================");
        System.out.println("         Task Management System       ");
        System.out.println("======================================");
        System.out.println("1) Crear usuario");
        System.out.println("2) Listar usuarios");
        System.out.println("3) Crear proyecto");
        System.out.println("4) Listar proyectos");
        System.out.println("5) Crear tarea");
        System.out.println("6) Listar tareas");
        System.out.println("7) Asignar tarea a usuario");
        System.out.println("8) Cambiar estado de tarea");
        System.out.println("9) Filtrar tareas");
        System.out.println("10) Eliminar tarea");
        System.out.println("0) Salir");
        System.out.println("======================================");
    }

    // ---------- Opciones ----------

    private void createUser() {
        String name = prompt("Nombre");
        var u = new User(name);
        userService.create(u);
        System.out.println("Usuario creado con ID: " + u.getId());
    }

    private void listUsers() {
        System.out.println("--- Usuarios ---");
        userService.findAll().forEach(u ->
                System.out.println(u.getId() + " | " + u.getName()));
        if (userService.findAll().isEmpty()) System.out.println("(sin usuarios)");
    }

    private void createProject() {
        String name = prompt("Nombre del proyecto");
        var p = new Project(name);
        projectService.create(p);
        System.out.println("Proyecto creado con ID: " + p.getId());
    }

    private void listProjects() {
        System.out.println("--- Proyectos ---");
        projectService.findAll().forEach(p ->
                System.out.println(p.getId() + " | " + p.getName()));
        if (projectService.findAll().isEmpty()) System.out.println("(sin proyectos)");
    }

    private void createTask() {
        String title = prompt("Título");
        String desc  = prompt("Descripción (opcional)");
        var t = new Task(title, desc);

        // priority
        String pr = prompt("Prioridad [LOW|MEDIUM|HIGH] (enter = MEDIUM)");
        if (!pr.isBlank()) {
            try { t.setPriority(Priority.valueOf(pr.trim().toUpperCase())); }
            catch (IllegalArgumentException e) { System.out.println("Prioridad inválida. Se deja MEDIUM."); }
        }

        // due date
        String due = prompt("Fecha vencimiento YYYY-MM-DD (enter = sin fecha)");
        if (!due.isBlank()) {
            try { t.setDueDate(LocalDate.parse(due.trim())); }
            catch (DateTimeParseException e) { System.out.println("Fecha inválida. Se deja sin fecha."); }
        }

        // project (optional)
        if (!projectService.findAll().isEmpty()) {
            System.out.println("¿Asignar a un proyecto? (enter = no)");
            listProjects();
            String pid = prompt("ID de proyecto");
            if (!pid.isBlank()) {
                projectService.findById(parseUUID(pid)).ifPresentOrElse(t::setProject,
                        () -> System.out.println("Proyecto no encontrado, se omite."));
            }
        }

        // assignee (optional)
        if (!userService.findAll().isEmpty()) {
            System.out.println("¿Asignar a un usuario? (enter = no)");
            listUsers();
            String uid = prompt("ID de usuario");
            if (!uid.isBlank()) {
                userService.findById(parseUUID(uid)).ifPresentOrElse(t::setAssignee,
                        () -> System.out.println("Usuario no encontrado, se omite."));
            }
        }

        taskService.create(t);
        System.out.println("Tarea creada con ID: " + t.getId());
    }

    private void listTasks() {
        System.out.println("--- Tareas ---");
        if (taskService.findAll().isEmpty()) {
            System.out.println("(sin tareas)");
            return;
        }
        taskService.findAll().forEach(this::printTask);
    }

    private void assignTaskToUser() {
        listTasks();
        String tid = prompt("ID de tarea");
        Optional<Task> opt = taskService.findById(parseUUID(tid));
        if (opt.isEmpty()) { System.out.println("Tarea no encontrada."); return; }

        listUsers();
        String uid = prompt("ID de usuario");
        Optional<User> ou = userService.findById(parseUUID(uid));
        if (ou.isEmpty()) { System.out.println("Usuario no encontrado."); return; }

        Task t = opt.get();
        t.setAssignee(ou.get());
        taskService.update(t);
        System.out.println("Asignada tarea " + t.getId() + " a " + ou.get().getName());
    }

    private void changeTaskStatus() {
        listTasks();
        String tid = prompt("ID de tarea");
        Optional<Task> opt = taskService.findById(parseUUID(tid));
        if (opt.isEmpty()) { System.out.println("Tarea no encontrada."); return; }

        System.out.println("Estados: TODO | IN_PROGRESS | DONE | BLOCKED");
        String st = prompt("Nuevo estado");
        try {
            TaskStatus status = TaskStatus.valueOf(st.trim().toUpperCase());
            Task t = opt.get();
            t.setStatus(status);
            taskService.update(t);
            System.out.println("Estado actualizado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Estado inválido.");
        }
    }

    private void filterTasks() {
        TaskFilter f = new TaskFilter();

        String st = prompt("Filtrar por estado (TODO|IN_PROGRESS|DONE|BLOCKED, enter = ninguno)");
        if (!st.isBlank()) {
            try { f.status = Optional.of(TaskStatus.valueOf(st.trim().toUpperCase())); }
            catch (IllegalArgumentException e) { System.out.println("Estado inválido. Se omite."); }
        }

        if (!userService.findAll().isEmpty()) {
            String uid = prompt("Filtrar por usuario (ID, enter = ninguno)");
            if (!uid.isBlank()) userService.findById(parseUUID(uid)).ifPresent(u -> f.assignee = Optional.of(u));
        }

        if (!projectService.findAll().isEmpty()) {
            String pid = prompt("Filtrar por proyecto (ID, enter = ninguno)");
            if (!pid.isBlank()) projectService.findById(parseUUID(pid)).ifPresent(p -> f.project = Optional.of(p));
        }

        String from = prompt("Desde (due date) YYYY-MM-DD (enter = no)");
        if (!from.isBlank()) try { f.dueFrom = Optional.of(LocalDate.parse(from.trim())); } catch (Exception ignored) { System.out.println("Fecha inválida (desde)."); }
        String to = prompt("Hasta (due date) YYYY-MM-DD (enter = no)");
        if (!to.isBlank()) try { f.dueTo = Optional.of(LocalDate.parse(to.trim())); } catch (Exception ignored) { System.out.println("Fecha inválida (hasta)."); }

        var result = taskService.findByFilter(f);
        System.out.println("--- Resultado (" + result.size() + ") ---");
        if (result.isEmpty()) System.out.println("(sin coincidencias)");
        result.forEach(this::printTask);
    }

    private void deleteTask() {
        listTasks();
        String tid = prompt("ID de tarea a eliminar");
        try {
            UUID id = parseUUID(tid);
            taskService.delete(id);
            System.out.println("Tarea eliminada (si existía).");
        } catch (Exception e) {
            System.out.println("ID inválido.");
        }
    }

    // ---------- Helpers ----------

    private void printTask(Task t) {
        String ass = (t.getAssignee() == null) ? "-" : t.getAssignee().getName();
        String proj = (t.getProject() == null) ? "-" : t.getProject().getName();
        String due  = (t.getDueDate() == null) ? "-" : t.getDueDate().toString();
        System.out.printf("%s | %-12s | %-7s | %-10s | due:%s | proj:%s | user:%s%n",
                t.getId(), t.getStatus(), t.getPriority(), t.getTitle(), due, proj, ass);
    }

    private String prompt(String label) {
        System.out.print(label + ": ");
        return in.nextLine();
    }

    private UUID parseUUID(String raw) {
        try { return UUID.fromString(raw.trim()); }
        catch (IllegalArgumentException e) { throw new IllegalArgumentException("UUID inválido"); }
    }
}
