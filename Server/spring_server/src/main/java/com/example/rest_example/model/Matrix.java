package com.example.rest_example.model;

public class Matrix {

    private Integer rowSize;
    private Integer colSize;
    private Integer[] values;

    public Matrix(Integer rowSize, Integer colSize){
        this.rowSize = rowSize;
        this.colSize = colSize;
        Integer[] valuesArray = new Integer[rowSize * colSize];

        for (int i = 0; i < rowSize * colSize; i++){
            valuesArray[i] = 0;
        }
        this.values = valuesArray;
    }

    public Integer getRowSize() {
        return rowSize;
    }

    public void setRowSize(Integer rowSize) {
        this.rowSize = rowSize;
    }


    public Integer getColSize() {
        return colSize;
    }

    public void setColSize(Integer colSize) {
        this.colSize = colSize;
    }


    public Integer[] getValues() {
        return values;
    }

    public void setValues(Integer[] values) {
        this.values = values;
    }

    public Integer getValue(Integer index){
        return values[index];
    }
    public void setValue(Integer index, Integer value){
        this.values[index] = value;
    }

}

