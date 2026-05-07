import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Salesfile {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int[] saleID = new int[100];
        String[] salesperson = new String[100];
        String[] region = new String[100];
        String[] product = new String[100];
        int[] quantity = new int[100];
        double[] unitPrice = new double[100];
        double[] totalSale = new double[100];
        int count = 0;

        System.out.print("Enter the path of the sales file: ");
        String path = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        boolean firstLine = true;

        while ((line = br.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String[] f = line.split(",");
            saleID[count] = Integer.parseInt(f[0].trim());
            salesperson[count] = f[1].trim();
            region[count] = f[2].trim();
            product[count] = f[3].trim();
            quantity[count] = Integer.parseInt(f[4].trim());
            unitPrice[count] = Double.parseDouble(f[5].trim());
            totalSale[count] = quantity[count] * unitPrice[count];
            count++;
        }
        br.close();

        System.out.println("\nFile loaded. Total records: " + count);

        System.out.println("\nID   Salesperson      Region   Product      Qty   UnitPrice   TotalSale");
        for (int i = 0; i < count; i++) {
            System.out.println(saleID[i] + "    " + salesperson[i] + "    " + region[i] + "    " + product[i] + "    "
                    + quantity[i] + "    " + unitPrice[i] + "    " + totalSale[i]);
        }

        double totalRevenue = 0;
        for (int i = 0; i < count; i++)
            totalRevenue = totalRevenue + totalSale[i];
        System.out.println("\nTotal Revenue = Rs. " + totalRevenue);

        double average = totalRevenue / count;
        System.out.println("Average Sale  = Rs. " + average);

        int maxIndex = 0;
        for (int i = 1; i < count; i++) {
            if (totalSale[i] > totalSale[maxIndex])
                maxIndex = i;
        }
        System.out.println("\nHighest Sale:");
        System.out.println("Salesperson : " + salesperson[maxIndex]);
        System.out.println("Product     : " + product[maxIndex]);
        System.out.println("Total Sale  : Rs. " + totalSale[maxIndex]);

        int minIndex = 0;
        for (int i = 1; i < count; i++) {
            if (totalSale[i] < totalSale[minIndex])
                minIndex = i;
        }
        System.out.println("\nLowest Sale:");
        System.out.println("Salesperson : " + salesperson[minIndex]);
        System.out.println("Product     : " + product[minIndex]);
        System.out.println("Total Sale  : Rs. " + totalSale[minIndex]);

        System.out.print("\nEnter a region to filter (North/South/East/West): ");
        String filterRegion = sc.nextLine();

        System.out.println("\nSales in Region: " + filterRegion);
        double regionTotal = 0;
        for (int i = 0; i < count; i++) {
            if (region[i].equalsIgnoreCase(filterRegion)) {
                System.out.println(salesperson[i] + " -> " + product[i] + " -> Rs. " + totalSale[i]);
                regionTotal = regionTotal + totalSale[i];
            }
        }
        System.out.println("Region Total = Rs. " + regionTotal);

        sc.close();
    }
}