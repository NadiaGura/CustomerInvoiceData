package company.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class UsersController {


    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addUser() {

        System.out.print("Enter the name of the user: ");
        String name = scanner.next();

        System.out.print("Enter the surname of the user: ");
        String surname = scanner.next();

        System.out.print("Enter the username of the user: ");
        String username = scanner.next();

        System.out.print("Enter the password of the user: ");
        String password = scanner.next();

        System.out.print("Enter the role of the user: ");
        String role = scanner.next();

        try {
            ps = getConnection().prepareStatement("INSERT INTO users (username, password, name, surname, role) VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, surname);
            ps.setString(5, role);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }


        // Method to delete user for admin

        public static boolean deleteUser () {

            System.out.print("Enter the id of the user: ");
            int id = scanner.nextInt();
            try {
                ps = getConnection().prepareStatement("DELETE FROM users WHERE id=" + id);
                ps.execute();
                return true;

            } catch (SQLException e) {
                System.out.println("Database Error");
                return false;

            }


        }

    public static boolean editUser() {

        System.out.println("Enter the id of the user: ");
        int id = scanner.nextInt();
        System.out.println("Enter new name:");
        String newName = scanner.next();
        System.out.println("Enter new role:");
        String newRole = scanner.next();
        try {
            ps = getConnection().prepareStatement("UPDATE products SET name ='" + newName + "' WHERE id =" + id);
            ps = getConnection().prepareStatement("UPDATE products SET price ='" + newRole + "' WHERE id =" + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }

    }

}
