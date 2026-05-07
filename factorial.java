// ============================================================
// OBJECT #13 - Matrix Addition using Functions
// ============================================================

import java.util.Scanner;

public class Matrixadditionfunction {

    static int[][] addMatrices(int[][] a, int[][] b) {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                result[i][j] = a[i][j] + b[i][j];
        return result;
    }

    static void inputMatrix(int[][] matrix, String name, Scanner sc) {
        System.out.println("Enter elements of Matrix " + name + " (3x3):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(name + "[" + i + "][" + j + "] = ");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid! Enter an integer.");
                    sc.next();
                }
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    static void printMatrix(int[][] matrix, String label) {
        System.out.println(label + ":");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrixA = new int[3][3];
        int[][] matrixB = new int[3][3];

        inputMatrix(matrixA, "A", sc);
        System.out.println();
        inputMatrix(matrixB, "B", sc);
        System.out.println();

        int[][] result = addMatrices(matrixA, matrixB);

        printMatrix(matrixA, "Matrix A");
        printMatrix(matrixB, "Matrix B");
        printMatrix(result, "Result (A + B)");

        sc.close();
    }
}