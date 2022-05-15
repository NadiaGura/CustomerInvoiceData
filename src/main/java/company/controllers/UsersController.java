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
        System.out.println("Enter username:");
        String newUsername = scanner.nextLine();
        System.out.println("Enter password:");
        String newPassword = scanner.nextLine();
        System.out.println("Enter name:");
        String newName = scanner.nextLine();
        System.out.println("Enter surname:");
        String newSurname = scanner.nextLine();
        System.out.println("Enter role:");
        String newRole = scanner.nextLine();

        try {
            ps = getConnection().prepareStatement("INSERT INTO users (username, password, name, surname, role)" +
                    " VALUES(?, ?, ?, ?, ? )");
            ps.setString(1, newUsername);
            ps.setString(2, newPassword);
            ps.setString(3, newName);
            ps.setString(4, newSurname);
            ps.setString(5, newRole);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }

    }

    public static boolean deleteUser() {

                System.out.print("Enter the id of the user: ");
                int id = scanner.nextInt();
                try {
                    ps = getConnection().prepareStatement("DELETE FROM users WHERE id=" + id);
                    ps.execute();

                } catch (SQLException e) {
                    System.out.println("Database Error");

                }
            return false;
    }

    public static boolean editUser() {

        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter new password:");
        String newPassword = scanner.nextLine();
        System.out.println("Enter new name:");
        String newName = scanner.nextLine();
        System.out.println("Enter new surname:");
       String newSurname = scanner.nextLine();
        System.out.println("Enter new role:");
        String newRole = scanner.nextLine();
        try {
            ps = getConnection().prepareStatement("UPDATE users SET password ='" + newPassword + "' WHERE username ='" + username + "'");
            ps.execute();
            ps = getConnection().prepareStatement("UPDATE users SET name ='" + newName + "' WHERE username ='"  + username + "'");
            ps.execute();
            ps = getConnection().prepareStatement("UPDATE users SET surname ='" + newSurname + "' WHERE username ='"  + username + "'");
            ps.execute();
            ps = getConnection().prepareStatement("UPDATE users SET role ='" + newRole + "' WHERE username ='"  + username + "'");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }

    }

   }

