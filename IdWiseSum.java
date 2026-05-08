import java.util.Scanner;
import java.io.File;

class idWiseSum {
    public static void main(String[] args) {

        try {
            Scanner file = new Scanner(new File("SalesEVESession.txt"));

            String header = file.nextLine();

            String[] ids = new String[100];
            double[] totals = new double[100];
            int count = 0;

            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] parts = line.split("\t");

                String id = parts[0];
                double price = Double.parseDouble(parts[2]);
                double quantity = Double.parseDouble(parts[3]);
                double amount = price * quantity;

                boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (ids[i].equals(id)) {
                        totals[i] = totals[i] + amount;
                        found = true;
                        break;
                    }
                }

                if (found == false) {
                    ids[count] = id;
                    totals[count] = amount;
                    count++;
                }
            }

            System.out.println("\nID-wise Results:");
            for (int i = 0; i < count; i++) {
                System.out.println("ID: " + ids[i] + " = Total: " + totals[i]);
            }

            file.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}