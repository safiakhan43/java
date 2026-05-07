import java.util.Scanner;

public class Hammingcodes {

    static String[] hammingCodes(int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = "d";

        int hCount = 1;
        int position = 1;

        while (position <= n) {
            arr[position - 1] = "h" + hCount;
            hCount++;
            position = position * 2;
        }

        return arr;
    }

    static void printArray(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array (N): ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid! Enter an integer.");
            sc.next();
        }
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Size must be greater than 0.");
            sc.close();
            return;
        }

        String[] plain = new String[n];
        for (int i = 0; i < n; i++)
            plain[i] = "d";

        System.out.print("Plain text array  : ");
        printArray(plain);

        System.out.print("After HammingCodes: ");
        printArray(hammingCodes(n));

        sc.close();
    }
}