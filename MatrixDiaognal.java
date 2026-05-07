import java.util.Scanner;

public class MatrixDiaognal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] matrix = new int[3][3];

        System.out.println("Enter elements of the Matrix (3x3):");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter an integer.");
                    System.out.print("matrix[" + i + "][" + j + "] = ");
                    sc.next();
                }
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nYour Matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int principalSum = 0;
        int secondarySum = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    principalSum = principalSum + matrix[i][j];
                if (i + j == 2)
                    secondarySum = secondarySum + matrix[i][j];
            }
        }

        int totalSum = principalSum + secondarySum - matrix[1][1];

        System.out.println("\nSum of Principal Diagonal = " + principalSum);
        System.out.println("Sum of Secondary Diagonal = " + secondarySum);
        System.out.println("Total (center counted once) = " + totalSum);

        sc.close();
    }
}