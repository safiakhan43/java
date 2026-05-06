import java.util.Scanner;

public class MatrixSubtraction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] matrixA = new int[3][3];
        int[][] matrixB = new int[3][3];
        int[][] result = new int[3][3];

        System.out.println("Enter elements of Matrix A (3x3):");
        System.out.println("(Only integers are accepted)");
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");

                while (!sc.hasNextInt()) {
                    System.out.println("  Invalid input! Please enter an integer.");
                    System.out.print("A[" + i + "][" + j + "] = ");
                    sc.next();
                }
                matrixA[i][j] = sc.nextInt();
            }
        }

        System.out.println();

        System.out.println("Enter elements of Matrix B (3x3):");
        System.out.println("(Only integers are accepted)");
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("B[" + i + "][" + j + "] = ");

                while (!sc.hasNextInt()) {
                    System.out.println("  Invalid input! Please enter an integer.");
                    System.out.print("B[" + i + "][" + j + "] = ");
                    sc.next();
                }
                matrixB[i][j] = sc.nextInt();
            }
        }

        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        System.out.println("Matrix A:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrixA[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Matrix B:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrixB[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Result (A - B):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}
