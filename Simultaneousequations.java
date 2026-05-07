import java.util.Scanner;

public class Simultaneousequations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // augmented matrix [A|B] of size 3x4
        // each row is: a b c | d
        // representing: ax + by + cz = d
        double[][] matrix = new double[3][4];

        System.out.println("Enter coefficients for 3 equations:");
        System.out.println("Format: a b c d  (for ax + by + cz = d)");
        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.println("Equation " + (i + 1) + ":");
            for (int j = 0; j < 4; j++) {
                if (j == 0)
                    System.out.print("  coefficient of x = ");
                else if (j == 1)
                    System.out.print("  coefficient of y = ");
                else if (j == 2)
                    System.out.print("  coefficient of z = ");
                else
                    System.out.print("  right hand side   = ");

                while (!sc.hasNextDouble()) {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next();
                }
                matrix[i][j] = sc.nextDouble();
            }
            System.out.println();
        }

        System.out.println("Original Augmented Matrix:");
        printMatrix(matrix);

        // ── STEP 1: Forward Elimination (Row Echelon Form) ──────────
        // Goal: make everything BELOW the diagonal = 0
        // We do this column by column (pivot column)

        System.out.println("Applying Row Operations...");
        System.out.println();

        for (int col = 0; col < 3; col++) {

            // find a non-zero pivot in this column
            if (matrix[col][col] == 0) {
                for (int row = col + 1; row < 3; row++) {
                    if (matrix[row][col] != 0) {
                        double[] temp = matrix[col];
                        matrix[col] = matrix[row];
                        matrix[row] = temp;
                        System.out.println("Swapped Row " + col + " and Row " + row);
                        printMatrix(matrix);
                        break;
                    }
                }
            }

            // eliminate all rows below the pivot row
            for (int row = col + 1; row < 3; row++) {
                if (matrix[col][col] == 0)
                    continue;

                double factor = matrix[row][col] / matrix[col][col];

                System.out.println("R" + row + " = R" + row + " - (" + formatNum(factor) + ") * R" + col);

                for (int j = 0; j < 4; j++)
                    matrix[row][j] = matrix[row][j] - factor * matrix[col][j];

                printMatrix(matrix);
            }
        }

        double[] solution = new double[3];
        boolean noSolution = false;
        for (int i = 0; i < 3; i++) {
            double rowCoeffSum = 0;
            for (int j = 0; j < 3; j++)
                rowCoeffSum = rowCoeffSum + Math.abs(matrix[i][j]);
            if (rowCoeffSum == 0 && matrix[i][3] != 0) {
                noSolution = true;
                break;
            }
        }

        if (noSolution) {
            System.out.println("RESULT: No solution exists (inconsistent system).");
        } else {

            System.out.println("Applying Back Substitution...");
            System.out.println();

            for (int i = 2; i >= 0; i--) {
                solution[i] = matrix[i][3];
                for (int j = i + 1; j < 3; j++)
                    solution[i] = solution[i] - matrix[i][j] * solution[j];
                if (matrix[i][i] != 0)
                    solution[i] = solution[i] / matrix[i][i];
            }

            System.out.println("RESULT:");
            System.out.println("x = " + formatNum(solution[0]));
            System.out.println("y = " + formatNum(solution[1]));
            System.out.println("z = " + formatNum(solution[2]));
        }

        sc.close();
    }

    static void printMatrix(double[][] m) {
        for (int i = 0; i < 3; i++) {
            System.out.print("[ ");
            for (int j = 0; j < 4; j++) {
                System.out.printf("%8.2f ", m[i][j]);
            }
            System.out.println("]");
        }
        System.out.println();
    }

    static String formatNum(double val) {
        if (val == (long) val)
            return String.valueOf((long) val);
        return String.format("%.4f", val);
    }
}