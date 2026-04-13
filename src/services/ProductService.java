package services;

import entities.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProductService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Desativa modo permissivo do SimpleDateFormat
    static {
        sdf.setLenient(false);
    }

    public static Product createProduct(char type, Scanner sc) throws ParseException {

        System.out.print("Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        double price = readPositiveDouble(sc, "Price: ");

        if (type == 'i') {

            double customsFee = readPositiveDouble(sc, "Customs fee: ");
            return new ImportedProduct(name, price, customsFee);

        } else if (type == 'u') {

            Date manufactureDate = readValidDate(sc, "Manufacture date (DD/MM/YYYY): ");
            return new UsedProduct(name, price, manufactureDate);

        } else if (type == 'c') {

            return new Product(name, price);

        } else {
            throw new IllegalArgumentException("Invalid product type");
        }
    }

    // -------------------------
    // VALIDAÇÃO DE NÚMERO
    // -------------------------
    private static double readPositiveDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.next();

            try {
                double value = Double.parseDouble(input);

                if (value <= 0) {
                    System.out.println("Value must be greater than zero.");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a numeric value.");
            }
        }
    }

    // -------------------------
    // VALIDAÇÃO DE DATA
    // -------------------------
    private static Date readValidDate(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.next();

            try {
                return sdf.parse(input);
            } catch (ParseException e) {
                System.out.println("Invalid date. Use format DD/MM/YYYY.");
            }
        }
    }

    public static void printPriceTags(List<Product> products) {
        System.out.println("\n--- Price Tags ---");
        for (Product p : products) {
            System.out.println(p.priceTag());
        }
    }
}