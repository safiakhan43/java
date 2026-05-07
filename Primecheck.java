
import java.util.Scanner;

public class Primecheck {

    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to check if it is Prime: ");

        while (!sc.hasNextInt()) {
            System.out.println("Invalid! Enter an integer.");
            sc.next();
        }

        int n = sc.nextInt();

        if (isPrime(n))
            System.out.println(n + " is a Prime number.");
        else
            System.out.println(n + " is NOT a Prime number.");

        sc.close();
    }
}