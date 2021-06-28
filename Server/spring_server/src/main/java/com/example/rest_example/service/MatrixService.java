package com.example.rest_example.service;

import com.example.rest_example.model.Matrix;

public interface MatrixService {

    /**
     * Создание матрицы из полученной от клиента строки, содержащей корректную запись матрицы
     * @param matrixString строка, содержащая матрицу
     * @param rowSize количество строк результирующей матрицы
     * @param colSize количество столбцов результирующей матрицы
     * @return матрица
     */
    Matrix parseMatrixFromString(String matrixString, Integer rowSize, Integer colSize);

    /**
     * Упаковка матрицы в строку для отправки клиенту
     * @param matrix матрица
     * @return строка, содержащая запись матрицы
     */
    String createStringFromMatrix(Matrix matrix);


    /**
     * Умножение двух матриц
     * @param matrixLeft левый операнд
     * @param matrixRight правый операнд
     * @return матрица - результат оперцации умножения
     */
    Matrix multiplication(Matrix matrixLeft, Matrix matrixRight);

    /**
     * Сложение двух матриц
     * @param matrixLeft - левый операнд
     * @param matrixRight - правый операнд
     * @return - результат операции сложения
     */
    Matrix addition(Matrix matrixLeft, Matrix matrixRight);

}
