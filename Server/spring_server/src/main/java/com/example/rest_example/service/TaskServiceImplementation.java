package com.example.rest_example.service;

import com.example.rest_example.model.Matrix;
import com.example.rest_example.model.Task;
import com.example.rest_example.service.MatrixService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TaskServiceImplementation implements TaskService {
    // Хранилище задач
    private static final Map<Integer, Task> TASK_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID задачи
    private static final AtomicInteger TASK_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Task task) {
        final int taskId = TASK_ID_HOLDER.incrementAndGet();
        task.setTaskId(taskId);
        //creating matrices
        Matrix matrixLeft = new Matrix(task.getMatrixLeftRowSize(), task.getMatrixLeftColSize());
        Matrix matrixRight = new Matrix(task.getMatrixRightRowSize(), task.getMatrixRightColSize());
        Matrix matrixRes = new Matrix(task.getMatrixLeftRowSize(), task.getMatrixRightColSize());

        //raeding strings
        MatrixServiceImplementation matrixOperation = new MatrixServiceImplementation();
        matrixLeft = matrixOperation.parseMatrixFromString(task.getMatrixLeft(), task.getMatrixLeftRowSize(), task.getMatrixLeftColSize());
        matrixRight = matrixOperation.parseMatrixFromString(task.getMatrixRight(), task.getMatrixRightRowSize(), task.getMatrixRightColSize());
        //operation
        matrixRes = matrixOperation.addition(matrixLeft, matrixRight);

        String resString = matrixOperation.createStringFromMatrix(matrixRes);
        task.setRes(resString);
        //
        TASK_REPOSITORY_MAP.put(taskId, task);
    }

    @Override
    public List<Task> readAll() {
        return new ArrayList<>(TASK_REPOSITORY_MAP.values());
    }

    @Override
    public Task read(int id) {
        return TASK_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Task task, int id) {
        if (TASK_REPOSITORY_MAP.containsKey(id)) {
            task.setTaskId(id);
            TASK_REPOSITORY_MAP.put(id, task);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return TASK_REPOSITORY_MAP.remove(id) != null;
    }
}
