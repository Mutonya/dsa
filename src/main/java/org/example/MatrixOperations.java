package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MatrixOperations {
    public static int[] computeMatrixOperations(int[][] matrix) {
        int n = matrix.length; // Assuming the matrix is square (n x n)

        int mainDiagonalSum = 0;
        int rowRepeatCount = 0;
        int columnRepeatCount = 0;

        // Compute sum of main diagonal and check for repeated rows/columns
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();

        return getInts(matrix, n, mainDiagonalSum, rowRepeatCount, columnRepeatCount);
    }

    static int[] getInts(int[][] matrix, int n, int mainDiagonalSum, int rowRepeatCount, int columnRepeatCount) {
        for (int i = 0; i < n; i++) {
            mainDiagonalSum += matrix[i][i];

            Set<Integer> rowElements = new HashSet<>();
            Set<Integer> columnElements = new HashSet<>();

            for (int j = 0; j < n; j++) {
                rowElements.add(matrix[i][j]);
                columnElements.add(matrix[j][i]);
            }

            if (rowElements.size() < n) {
                rowRepeatCount++;
            }
            if (columnElements.size() < n) {
                columnRepeatCount++;
            }
        }

        return new int[]{mainDiagonalSum, rowRepeatCount, columnRepeatCount};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the matrix size (assuming square matrix)
        System.out.print("Enter the matrix size (n x n): ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        // Input the matrix elements
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] result = computeMatrixOperations(matrix);
        System.out.println("Main Diagonal Sum: " + result[0]);
        System.out.println("Rows with Repeated Elements: " + result[1]);
        System.out.println("Columns with Repeated Elements: " + result[2]);
    }
}

