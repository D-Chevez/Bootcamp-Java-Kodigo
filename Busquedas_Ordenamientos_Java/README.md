# 🚀 Proyecto: Algoritmos de Búsqueda y Ordenamiento en Java

Este proyecto implementa **algoritmos de búsqueda y ordenamiento en Java**, utilizando principios de programación orientada a objetos y buenas prácticas, como parte de las actividades del bootcamp.

---

## 📌 Funcionalidades
✅ **Algoritmos de búsqueda:**
- Búsqueda Secuencial.
- Búsqueda Binaria.

✅ **Algoritmos de ordenamiento:**
- Bubble Sort.
- Insertion Sort.
- Selection Sort.

✅ **Medición de tiempos de ejecución** con `System.nanoTime()`.  
✅ **Visualización de complejidades (mejor, peor y promedio)** para cada operacion algorítmica.  
✅ **Historial de operaciones** realizadas durante la sesión.  
✅ Código modular, mantenible y alineado con **principios SOLID**.

---

## 🛠️ Tecnologías utilizadas

- **Java SE 24+**
- **IDE:** IntelliJ IDEA / Eclipse
- Consola / Terminal

---

## 📂 Estructura del proyecto
```text
Busquedas_Ordenamientos/
├── Main.java
├── Searcher.java
├── Sorter.java
├── OperationRecord.java
└── Util.java
```

---

## 🎮 ¿Cómo ejecutar?

### **1️⃣ Java instalado:**
Para poder probar y utilizar este proyecto deberas tener una version de **java +17**, para verificar esto en la terminal puedes ejecutar el comando:
```bash
javac --version
```

### **2️⃣ Directorio proyecto:**
Ubicate en el directorio principal del proyecto y accede a la carpeta de recursos.
```text
Busquedas_Ordenamientos_Java/
├── Busquedas_Ordenamientos/ (Directorio principal)
├───├──src (Recursos)
├───└──└──clases.java
└── Otros_documentos.ext
```

### **3️⃣ Compilado proyecto:**
En el directorio principal, abre una terminal en la carpeta del proyecto y ejecuta:
```bash
javac *.java
```

### **4️⃣ Ejecucion**
Luego de compilar las clases y archivos java, deberas correr el programa mediante el siguiente comando:
```bash
java Main
```

---

## 👨‍💻 Uso del sistema

### **1️⃣ Inicio:**
Al iniciar, se mostrara el menu principal, el cual te solicitara una opcion para realizar una de las siguientes acciones:
- Realizar búsqueda secuencial o binaria.
- Ordenar con Bubble Sort, Insertion Sort o Selection Sort.
- Visualizar historial de operaciones.
- Salir del programa.

### **2️⃣ Búsquedas u ordenamientos:**
Durante las búsquedas u ordenamientos:
- Se muestra el dataset disponible.
- Se mide el tiempo de ejecución.
- Se indica la complejidad en una sola línea.
- Tras cada operación, puedes repetir, regresar o salir.

### **3️⃣ Historial y analisis:**
Puedes consultar el historial de operaciones en cualquier momento, mediante el menu principal. En el cual podras observas los siguientes datos:
- **Operation**: Muestra la operacion realizada.
- **Target**: Muestra el valor buscado en caso sea una busqueda.
- **Time(ns)**: Muestra el tiempo utilizada durante la ejecución.
- **Result**: Muestra el resultado, indice en caso de busqueda y sorted si el orden fue exitoso
- **Complexity**: Muestra la complejidad algoritmida de la operacion.

---

## 🎯 Objetivos de aprendizaje
✅ Comprender el funcionamiento de algoritmos de búsqueda y ordenamiento.  
✅ Analizar y comparar tiempos de ejecución y complejidades.  
✅ Mejorar habilidades de programación orientada a objetos en Java.  
✅ Aplicar principios SOLID y buenas prácticas de desarrollo.  

---

## ✍️ Autor
**Diego Chevez x Bootcamp Java - Kodigo**