import java.util.Scanner;

public class VendingMachineSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] productCodes = {"A", "B", "C", "D"};
        String[] products = {"Chips", "Chocolate", "Juice", "Biscuit"};
        int[] prices = {20, 30, 40, 25};
        int[] stock = {5, 3, 4, 6};

        System.out.println("==================================================");
        System.out.println("      VENDING MACHINE CONTROLLER SIMULATOR");
        System.out.println("==================================================");

        System.out.println("\nCode   Product      Price      Stock");

        for (int i = 0; i < products.length; i++) {
            System.out.println(productCodes[i] + "      "
                    + products[i] + "       Rs. "
                    + prices[i] + "       " + stock[i]);
        }

        System.out.print("\nEnter product code: ");
        char code = scanner.next().toUpperCase().charAt(0);

        int index = -1;

        switch (code) {
            case 'A':
                index = 0;
                break;
            case 'B':
                index = 1;
                break;
            case 'C':
                index = 2;
                break;
            case 'D':
                index = 3;
                break;
            default:
                System.out.println("Invalid product code selected.");
                scanner.close();
                return;
        }

        System.out.println("Selected: " + products[index]);
        System.out.println("Price: Rs. " + prices[index]);

        if (stock[index] <= 0) {
            System.out.println("Item is out of stock.");
            scanner.close();
            return;
        }

        System.out.println("Stock available: YES");

        int totalInserted = 0;

        while (totalInserted < prices[index]) {
            System.out.print("Insert money (0 to cancel): Rs. ");

            int money = scanner.nextInt();

            if (money == 0) {
                break;
            }

            if (money < 0) {
                System.out.println("Invalid amount. Enter positive money.");
                continue;
            }

            totalInserted = totalInserted + money;
            System.out.println("Total inserted: Rs. " + totalInserted);
        }

        if (totalInserted >= prices[index]) {
            System.out.println("\nPayment successful!");

            int change = totalInserted - prices[index];
            System.out.println("Change returned: Rs. " + change);

            System.out.println("Dispensing " + products[index] + "...");

            stock[index]--;

            System.out.println("Transaction completed successfully.");
            System.out.println("Remaining stock of "
                    + products[index] + ": " + stock[index]);
        } else {
            System.out.println("\nInsufficient payment. Transaction cancelled.");
            System.out.println("Money returned: Rs. " + totalInserted);
        }

        scanner.close();
    }
}