import java.util.Scanner;
import java.io.File;

class Productwisesum {
    public static void main(String[] args) {

        System.out.println("Product-wise sum :");

        try {
            File f1 = new File("C:\\Users\\Muhammad Salman Khan\\java\\SalesEVESession.txt");
            Scanner file = new Scanner(f1);
            file.nextLine();

            String[] products = new String[100];
            double[] totals = new double[100];
            int count = 0;

            while (file.hasNextLine()) {
                String line = file.nextLine();

                String[] parts = line.split("\t");

                String productName = parts[1];
                double price = Double.parseDouble(parts[2]);
                double quantity = Double.parseDouble(parts[3]);
                double amount = price * quantity;

                boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (products[i].equals(productName)) {
                        // Product found, add to its total
                        totals[i] = totals[i] + amount;
                        found = true;
                        break;
                    }
                }

                if (found == false) {
                    products[count] = productName;
                    totals[count] = amount;
                    count++;
                }
            }

            System.out.println("\nResults:");
            for (int i = 0; i < count; i++) {
                System.out.println(products[i] + " = " + totals[i]);
            }

            file.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}