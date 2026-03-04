import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
       
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        
        
        int[][] matrix = new int[rows][cols];
        
        
        System.out.println("\nEnter the elements row by row:");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print("Enter element at position [" + (i+1) + "][" + (j+1) + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }   
        System.out.println("\nYour Matrix:");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }  
        System.out.println("\n--- SUM OF ROWS ---");
        for(int i = 0; i < rows; i++) {
            int rowSum = 0;
            for(int j = 0; j < cols; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Sum of Row " + (i+1) + ": " + rowSum);
        }  
        System.out.println("\n--- SUM OF COLUMNS ---");
        for(int j = 0; j < cols; j++) {
            int colSum = 0;
            for(int i = 0; i < rows; i++) {
                colSum += matrix[i][j];
            }
            System.out.println("Sum of Column " + (j+1) + ": " + colSum);
        }
        System.out.println("\n--- DIAGONAL SUMS ---");
        if(rows == cols) {
            
            int forwardDiagSum = 0;
            for(int i = 0; i < rows; i++) {
                forwardDiagSum += matrix[i][i];
            }
            System.out.println("Forward Diagonal Sum (top-left to bottom-right): " + forwardDiagSum);
                
            int reverseDiagSum = 0;
            for(int i = 0; i < rows; i++) {
                reverseDiagSum += matrix[i][cols-1-i];
            }
            System.out.println("Reverse Diagonal Sum (top-right to bottom-left): " + reverseDiagSum);
        } else {
            System.out.println("Diagonal sums are only possible for square matrices (rows = columns)");
        }
        
        sc.close();
    }
}