package company.menu;

import company.controllers.InvoiceController;
import company.objects.Users;

import java.util.Scanner;

public class AdminsMenu {

    public static void menu (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, admin! Choose one: ");
        System.out.println("1. Users.");
        System.out.println("2. Inventory.");
        System.out.println("3. Invoices.");

        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch(option) {
            case 1:
                System.out.println(UsersMenu.menu());
                break;
            case 2:
                System.out.println(InventoryMenu.menu());
                break;
            case 3:
                System.out.println(InvoiceMenu.menu());
                break;

            default:
                System.out.println("Invalid option. Try again.");
                menu();
        }


    }
}
