import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String paymentType = before_or_after(scan);

        double amountSpent = 0.0;
        double gallonsPurchased = 0.0;

        if (paymentType.equalsIgnoreCase("before")) {
            System.out.println("How much are you spending?");
            System.out.print("> ");
            amountSpent = scan.nextDouble();

            double price = get_grade(scan);
            gallonsPurchased = get_gallons(amountSpent, price);
        } else {
            double price = get_grade(scan);

            System.out.println("How many gallons of gas did you pump?");
            System.out.print("> ");
            gallonsPurchased = scan.nextDouble();

            amountSpent = calculate_total_cost(gallonsPurchased, price);
        }

        System.out.println("Thank you for your purchase!");
        System.out.println("Payment: " + paymentType.toLowerCase());
        System.out.printf("Amount spent: $%.2f%n", amountSpent);
        System.out.printf("Gallons purchased: %.1f%n", gallonsPurchased);

        scan.close();
    }

    public static String before_or_after(Scanner scan) {
        System.out.println("Pay before or after?");
        System.out.print("> ");
        return scan.next();
    }

    public static double get_grade(Scanner scan) {
        System.out.println("What grade?");
        System.out.println("- Regular $2.50/gal");
        System.out.println("- Mid-grade $3.00/gal");
        System.out.println("- Premium $3.50/gal");
        System.out.print("> ");

        String grade = scan.next();

        if (grade.equalsIgnoreCase("Regular")) {
            return 2.50;
        } else if (grade.equalsIgnoreCase("Mid-grade")) {
            return 3.00;
        } else if (grade.equalsIgnoreCase("Premium")) {
            return 3.50;
        } else {
            return 0.0;
        }
    }

    public static double get_gallons(double amountSpent, double pricePerGallon) {
        return amountSpent / pricePerGallon;
    }

    public static double calculate_total_cost(double gallons, double pricePerGallon) {
        return gallons * pricePerGallon;
    }
}
