import java.util.Scanner;

public class MatrixTranspose {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] matrix = new int[3][3];
        int[][] transpose = new int[3][3];

        System.out.println("Enter elements of the Matrix (3x3):");
        System.out.println("(Only integers are accepted)");
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");

                while (!sc.hasNextInt()) {
                    System.out.println("  Invalid input! Please enter an integer.");
                    System.out.print("matrix[" + i + "][" + j + "] = ");
                    sc.next();
                }
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                transpose[i][j] = matrix[j][i]; // swap row and column index
            }
        }

        System.out.println("Original Matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Transpose of the Matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(transpose[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}
