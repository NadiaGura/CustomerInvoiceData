package company.menu;

import company.controllers.UsersController;

import java.util.Scanner;

public class UsersMenu {
    public static boolean menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("1. Add a new user: ");
        System.out.println("2. Delete user: ");
        System.out.println("3. Edit user: ");

        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println(UsersController.addUser() ? "New user successfully added" : "User not added");
                break;
            case 2:
                System.out.println(UsersController.deleteUser() ? "User deleted" : "User not deleted");
                break;
            case 3:
                System.out.println(UsersController.editUser() ? "User's data edited" : "Data not edited");
                break;

            default:
                System.out.println("Invalid option. Try again.");
                menu();
        }
        return false;
    }
}
