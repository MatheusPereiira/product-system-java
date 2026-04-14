package application;

import entities.Product;
import java.util.*;
import services.ProductService;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.println("\n--- Product Registration ---");
        System.out.print("Number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            try {
                System.out.println("\nProduct #" + i);
                System.out.print("Type [c=common, u=used, i=imported]: ");
                char type = sc.next().toLowerCase().charAt(0);

                Product product = ProductService.createProduct(type, sc);
                list.add(product);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                i--; // repete o mesmo item
            }
        }

        ProductService.printPriceTags(list);
        sc.close();
    }
}