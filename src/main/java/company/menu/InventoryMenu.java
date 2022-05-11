package company.menu;

import company.controllers.ProductController;
import company.controllers.UsersController;

import java.util.Scanner;

public class InventoryMenu {
    public static boolean menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("1. Check inventory!");
        System.out.println("2. Add a new product");
        System.out.println("3. Delete product");
        System.out.println("4. Edit product properties");
        System.out.println("5. Edit inventory (quantities)");

        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                ProductController.checkInventory();
                break;

            case 2:
                System.out.println(ProductController.addProduct() ? "New product successfully added" : "Product not added");
                break;
            case 3:
                System.out.println(ProductController.deleteProduct() ? "Product deleted" : "Product not deleted");
                break;
            case 4:
                System.out.println(ProductController.editProduct() ? "Products properties edited" : "Data not edited");
                break;
            case 5:
                ProductController.changeCount();
                break;
            default:
                System.out.println("Invalid option. Try again.");
                menu();
        }

        return false;
    }
}
