package company.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class UsersController {

    //SCANNER
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;


    //   public class StudentController {

//        //initialize scanner
//        private Scanner sc = new Scanner(System.in);
//        private PreparedStatement ps;
//        private ResultSet rs;
//
//        //METHOD TO GET/READ INVENTORY BY ID/NAME
//        public  boolean getProductById(){
//            //ask user for data
//            System.out.println("Please enter product ID: ");
//            int id = sc.nextInt();
//
////            System.out.println("Enter name of the product: ");
////            String name = sc.next();
//
//
//            //UPDATE WITH CORRECT QUERY FROM DB//
//            try {
//                ps = getConnection().prepareStatement("SELECT * FROM inventory WHERE id = " + id);
//                rs = ps.executeQuery();
//
//                //define var to temporarily hold each field in the result set.
//                int id, price;
//                String name;
//
//                //instantiate the student objet to return at the end of the method execution
//                Inventory inventory = new Inventory();
//
//                //loop through the result set and add the necessary values in the inventory object
//                while (rs.next()) {
//                    id = rs.getInt("id");
//                    name = rs.getString("name");
//                    price = rs.getInt("price");
//                    inventory.setName(name);
//                    inventory.setId(id);
//                    inventory.setPrice(price);
//                }
//                return inventory;
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//
//
//

    //ADD USER METHOD
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

    //DELETE USER METHOD
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

    //EDIT USER METHOD
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
            ps = getConnection().prepareStatement("UPDATE users SET name ='" + newName + "' WHERE username ='" + username + "'");
            ps.execute();
            ps = getConnection().prepareStatement("UPDATE users SET surname ='" + newSurname + "' WHERE username ='" + username + "'");
            ps.execute();
            ps = getConnection().prepareStatement("UPDATE users SET role ='" + newRole + "' WHERE username ='" + username + "'");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }

    //METHOD TO CHECK ROLE FOR ADMIN/USER
    public static boolean checkIfAdmin() {

        System.out.print("Enter your id: ");
        int id = scanner.nextInt();
        try {

            ps = getConnection().prepareStatement("SELECT * FROM users WHERE id=" + id);
            rs = ps.executeQuery();
            String userRole;
            while (rs.next()) {
                userRole = rs.getString("role");
                if (userRole.equals("admin")) {
                    return true;

                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database error");
            return false;
        }
        return false;
    }
}

