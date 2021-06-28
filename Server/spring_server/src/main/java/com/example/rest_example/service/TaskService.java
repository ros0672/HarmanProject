package com.example.rest_example.service;

import com.example.rest_example.model.Task;

import java.util.List;

public interface TaskService {/**
 * Создает новую задачу
 * @param task - задача для создания
 */
    void create(Task task);

    /**
     * Возвращает список всех имеющихся задач
     * @return список задач
     */
    List<Task> readAll();

    /**
     * Возвращает задачу по ID
     * @param id - ID задачи
     * @return - объект задачи с заданным ID
     */
    Task read(int id);

    /**
     * Обновляет задачу с заданным ID
     * в соответствии с переданной
     * @param task - задача, в соответсвии с которой нужно обновить данные
     * @param id - id задачи, которую нужно обновить
     * @return - true, если данные были обновлены, иначе false
     */
    boolean update(Task task, int id);

    /**
     * Удаляет задачу с заданным ID
     * @param id - id задачи, которую нужно удалить
     * @return - true, если задача была удалена, иначе false
     */
    boolean delete(int id);
}
