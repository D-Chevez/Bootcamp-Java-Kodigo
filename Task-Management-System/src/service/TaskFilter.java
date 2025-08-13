package service;

import model.Task;

import java.util.function.Predicate;

/**
 * Strategy to filter tasks (OCP).
 * New filters can be added without modifying TaskService implementation.
 */
public interface TaskFilter extends Predicate<Task> { }
