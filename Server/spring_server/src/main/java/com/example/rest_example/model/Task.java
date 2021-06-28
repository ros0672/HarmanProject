package com.example.rest_example.model;

public class Task {
    private Integer taskId; //id задачи
    private Integer operationId; //операция

    private String matrixLeft; //левый операнд
    private Integer matrixLeftRowSize; //к-во строк в левой матрице
    private Integer matrixLeftColSize; //к-во столбцов в левой матрице

    private String matrixRight; //правый операнд
    private Integer matrixRightRowSize; //к-во строк в правой матрице
    private Integer matrixRightColSize; //к-во столбцов в правой матрице

    private String res; //результат



    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }



    public String getMatrixLeft() {
        return matrixLeft;
    }

    public void setMatrixLeft(String matrixLeft) {
        this.matrixLeft = matrixLeft;
    }

    public Integer getMatrixLeftRowSize() {
        return matrixLeftRowSize;
    }
    public void setMLeftRowSize(Integer matrixLeftRowSize) {
        this.matrixLeftRowSize = matrixLeftRowSize;
    }

    public Integer getMatrixLeftColSize() {
        return matrixLeftColSize;
    }
    public void setMatrixLeftColSize(Integer matrixLeftColSize) {
        this.matrixLeftColSize = matrixLeftColSize;
    }



    public String getMatrixRight() {
        return matrixRight;
    }

    public void setMatrixRight(String matrixRight) {
        this.matrixRight = matrixRight;
    }

    public Integer getMatrixRightRowSize() {
        return matrixRightRowSize;
    }
    public void setMatrixRightRowSize(Integer matrixRightRowSize) {
        this.matrixRightRowSize = matrixRightRowSize;
    }

    public Integer getMatrixRightColSize() {
        return matrixRightColSize;
    }
    public void setMatrixRightColSize(Integer matrixRightColSize) {
        this.matrixRightColSize = matrixRightColSize;
    }



    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
