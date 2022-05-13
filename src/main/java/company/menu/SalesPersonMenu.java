package company.menu;

import company.controllers.ProductController;

import java.util.Scanner;

public class SalesPersonMenu {
    public static void menu (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, user! Choose one: ");
        System.out.println("1. Check inventory.");
        System.out.println("2. Invoices.");
        System.out.println("3. Customers.");

        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch(option) {

            case 1:
                ProductController.checkInventory();
                break;
            case 2:
                System.out.println(InvoiceMenu.menu());
                break;
            case 3:
                System.out.println(CustomerMenu.menu());
                break;
            default:
                System.out.println("Invalid option. Try again.");
                menu();
        }


    }
}
