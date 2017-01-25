package ua.ck.zabochen.hw05;

/*
    Дана действительная квадратная матрица порядка N (N – нечетное), все элементы которой различны.
    Найти наибольший элемент среди стоящих на главной и побочной диагоналях и поменять его местами с элементом,
    стоящим на пересечении этих диагоналей.
 */

import java.util.Random;

public class Matrix {

    private int matrixSize;
    private int matrixRange;
    private int[][] matrix;

    public Matrix(int matrixSize, int matrixRange) {
        this.matrixSize = matrixSize;
        this.matrixRange = matrixRange;
        this.matrix = new int[matrixSize][matrixSize];
        matrixFill(matrix, matrixSize, matrixRange);
    }

    private void matrixFill(int[][] matrix, int matrixSize, int matrixRange) {
        Random random = new Random();
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = random.nextInt(matrixRange);
            }
        }

        // Print array
        // System.out.println(Arrays.deepToString(matrix) + "\n");
        System.out.println("Original matrix:");
        printMatrix(matrix);
        System.out.println("");
    }


    private void printMatrix(int[][] matrixRow) {
        for (int row = 0; row < matrixRow.length; row++) {
            for (int column = 0; column < matrixRow[row].length; column++) {
                System.out.print(matrixRow[row][column] + " ");
            }
            System.out.println("");
        }
    }

    public void findAndReplace() {
        int matrixMiddleRow = matrixSize / 2;
        int matrixMiddleColumn = matrixSize / 2;
        int matrixMaxRow = 0;
        int matrixMaxColumn = 0;

        // Find
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (matrix[matrixMaxRow][matrixMaxColumn] < matrix[i][j] && (i == j || j == matrixSize - i - 1)) {
                    matrixMaxRow = i;
                    matrixMaxColumn = j;
                    System.out.println("Found value: " + matrix[matrixMaxRow][matrixMaxColumn]);
                }
            }
        }

        // Replace
        int matrixMiddleValue = matrix[matrixMiddleRow][matrixMiddleColumn];
        int matrixMaxValue = matrix[matrixMaxRow][matrixMaxColumn];

        System.out.println("\nMiddle value: " + matrixMiddleValue);
        System.out.println("Max value: " + matrixMaxValue);

        matrix[matrixMiddleRow][matrixMiddleColumn] = matrix[matrixMaxRow][matrixMaxColumn];
        matrix[matrixMaxRow][matrixMaxColumn] = matrixMiddleValue;

        System.out.println("\nNew matrix:");
        printMatrix(matrix);
    }
}
