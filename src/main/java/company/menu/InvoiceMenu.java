package company.menu;

import company.controllers.InvoiceController;

import java.util.Scanner;

public class InvoiceMenu {

    public static void menu (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do? ");
        System.out.println("1. Add a new invoice");



        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch(option) {
            case 1:
                System.out.println(InvoiceController.createInvoice() ? "Successfully created new invoice" : "Invoice not created");
                break;

            default:
                System.out.println("Invalid option. Try again.");
                menu();
        }

    }
}
