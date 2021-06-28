package com.example.rest_example.service;

import com.example.rest_example.model.Matrix;

public class MatrixServiceImplementation implements MatrixService{

    @Override
    public Matrix parseMatrixFromString(String matrixString, Integer rowSize, Integer colSize){//ok
        Matrix matrixRes = new Matrix(rowSize, colSize);

        char[] matrixCharArray = matrixString.toCharArray();
        int position = 0;
        String numberString = "";

        for (char c: matrixCharArray){
            if ((c != ' ') && (c != '\n')){
                numberString += c; //запись числа для конвертации
            }
            else {

                if (numberString != "") {
                    matrixRes.setValue(position, Integer.parseInt(numberString));
                    position++;
                    numberString = "";
                }
            }
        }
        if (numberString != "") {
            matrixRes.setValue(position, Integer.parseInt(numberString));
        }
        return matrixRes;
    };

    @Override
    public String createStringFromMatrix(Matrix matrix){//ok
        String matrixString = "";
        for (int i = 0; i < matrix.getRowSize(); i++){
            for (int j = 0; j < matrix.getColSize(); j++){
                matrixString += matrix.getValue(i* matrix.getColSize() + j) + " ";
            }
            matrixString += "\n";
        }
        return matrixString.trim();
    };

    @Override
    public Matrix multiplication(Matrix matrixLeft, Matrix matrixRight){
        Matrix resMatrix = new Matrix(matrixLeft.getRowSize(), matrixRight.getColSize());
        return resMatrix;
    };

    @Override
    public Matrix addition(Matrix matrixLeft, Matrix matrixRight){//Ok
        Matrix resMatrix = new Matrix(matrixLeft.getRowSize(), matrixLeft.getColSize());


        for (int i = 0; i < resMatrix.getRowSize(); i++){
            for (int j = 0; j < resMatrix.getColSize(); j++){
                resMatrix.setValue(i* resMatrix.getColSize() + j,
                        matrixLeft.getValue(i* resMatrix.getColSize() + j) + matrixRight.getValue(i* resMatrix.getColSize() + j));
            }
        }
        return resMatrix;
    };
}
