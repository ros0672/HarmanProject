package com.example.test_app;

public class InputMatrix {

    public boolean hasAllowedSymbolsOnly(String m){//Tested -- OK
        String allowedSymbols = " 0123456789\n";
        if (m != null){
            //numbers, " " and "\n" only
            //
            char[] matrixArray = m.toCharArray();
            for (char c: matrixArray){
                int cIndex = allowedSymbols.indexOf(c);
                if (cIndex == -1){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    public Integer getRowSize(String m){//Tested -- OK
        Integer size = 0;
        if (m != null){
            //size = ...
            char[] matrixArray = m.trim().toCharArray(); //cut unexpected \n entries

            for (char c: matrixArray){
                if ((c != ' ') && (c != '\n')){ //ищем первое числовое вхождение, если оно есть
                    size = 1;
                    break;
                }
            }

            if (size == 0){ //если числе нет, размер 0-й
                return 0;
            }
            else {
                for (char c : matrixArray) {
                    if (c == '\n') {
                        size++;
                    }
                }
            }
        }
        return size;
    }

    public Integer getColSize(String m){
        Integer size = 0;
        int currentSize = 0;
        int nextRowPosition = 0;

        if (m != null){

            boolean isNumber = false;
            //size = ...
            char[] matrixArray = m.trim().toCharArray(); //cut unexpected entries
            for (int i = 0; i < matrixArray.length; i++) {//сколько элементов в первой строке?
                if ((matrixArray[i] != ' ') && (matrixArray[i] != '\n')) {
                    isNumber = true;
                } else {
                    if (isNumber == true) {//если было число
                        size++;
                        isNumber = false;
                    }
                    if (matrixArray[i] == '\n') {
                        nextRowPosition = i + 1;
                        isNumber = false;
                        break;
                    }
                }

            }

            if (isNumber == true){//учет последнего чила
                size++;
            }


            System.out.println("Size: " + size);
            for (int i = nextRowPosition; i < matrixArray.length; i++){
                if ((matrixArray[i] != ' ') && (matrixArray[i] != '\n')) {
                    isNumber = true;
                } else {
                    if (isNumber == true) {//если было число
                        currentSize++;
                        isNumber = false;
                    }
                    if (matrixArray[i] == '\n') {
                        System.out.println("currentSize = " + currentSize);
                        if (currentSize != size){
                            return -1;
                        }
                        else {
                            currentSize = 0;
                        }
                    }
                }
            }

            if (isNumber == true){//учет последнего чила
                currentSize++;
                if (currentSize != size){
                    return -1;
                }
            }

        }
        return size;
    }

}
