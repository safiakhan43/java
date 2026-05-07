
import java.util.Scanner;

public class Studentresult {

    static double getTotal(int[] marks) {
        int total = 0;
        for (int i = 0; i < marks.length; i++)
            total = total + marks[i];
        return total;
    }

    static double getAverage(int[] marks) {
        return getTotal(marks) / marks.length;
    }

    static String getGrade(double average) {
        if (average >= 90)
            return "A+";
        else if (average >= 80)
            return "A";
        else if (average >= 70)
            return "B";
        else if (average >= 60)
            return "C";
        else if (average >= 50)
            return "D";
        else
            return "F";
    }

    static String getResult(double average) {
        if (average >= 50)
            return "PASS";
        else
            return "FAIL";
    }

    static void printReport(String name, int[] marks) {
        String[] subjects = { "Math", "English", "Science", "Urdu", "Computer" };
        System.out.println("           STUDENT RESULT CARD          ");
        System.out.println("Student Name : " + name);
        for (int i = 0; i < marks.length; i++)
            System.out.println(subjects[i] + "\t\t: " + marks[i] + " / 100");

        System.out.println("Total Marks  : " + (int) getTotal(marks) + " / 500");
        System.out.printf("Average      : %.2f%%%n", getAverage(marks));
        System.out.println("Grade        : " + getGrade(getAverage(marks)));
        System.out.println("Result       : " + getResult(getAverage(marks)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        int[] marks = new int[5];
        String[] subjects = { "Math", "English", "Science", "Urdu", "Computer" };

        System.out.println("Enter marks out of 100 for each subject:");
        for (int i = 0; i < 5; i++) {
            System.out.print(subjects[i] + ": ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid! Enter an integer.");
                sc.next();
            }
            marks[i] = sc.nextInt();
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Marks must be between 0 and 100. Try again.");
                i--;
            }
        }

        printReport(name, marks);

        sc.close();
    }
}