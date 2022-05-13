package company.menu;

import company.controllers.InvoiceController;
import company.controllers.UsersController;

import java.util.Scanner;

public class InvoiceMenu {
    public static boolean menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("1. Create new invoice");
        System.out.println("2. Delete invoice");
        System.out.println("3. Edit invoice");


        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                InvoiceController.createInvoice();
                break;
            case 2:
                System.out.println(InvoiceController.deleteInvoice() ? "Invoice deleted" : "Invoice not deleted");
                break;
            case 3:
                System.out.println(InvoiceController.editInvoice() ? "Invoice's data edited" : "Data not edited");
                break;

            default:
                System.out.println("Invalid option. Try again.");
                menu();
        }

        return false;
    }
}
