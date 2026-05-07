
import java.util.Scanner;

public class Sumaverage {

    static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum = sum + arr[i];
        return sum;
    }

    static double getAverage(int[] arr) {
        return (double) getSum(arr) / arr.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers do you want to enter? ");
        while (!sc.hasNextInt()) {
            sc.next();
        }
        int n = sc.nextInt();

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid! Enter an integer.");
                sc.next();
            }
            numbers[i] = sc.nextInt();
        }

        System.out.println("\nSum     = " + getSum(numbers));
        System.out.println("Average = " + getAverage(numbers));

        sc.close();
    }
}