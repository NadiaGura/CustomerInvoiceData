package company.menu;

import company.controllers.CustomerController;

import java.util.Scanner;

public class CustomerMenu {
    public static boolean menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("1. Add a new customer: ");
        System.out.println("2. Delete customer: ");
        System.out.println("3. Edit customer: ");


        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println(CustomerController.addCustomer() ? "New customer successfully added" : "Customer not added");
                break;
            case 2:
                System.out.println(CustomerController.deleteCustomer() ? "Customer deleted" : "Customer not deleted");
                break;
            case 3:
                System.out.println(CustomerController.editCustomer() ? "Customer's data edited" : "Data not edited");
                break;

            default:
                System.out.println("Invalid option. Try again.");
                menu();
        }
        return false;
    }
}