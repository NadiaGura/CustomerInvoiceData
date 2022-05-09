package company.controllers;

import company.objects.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class ProductController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static Product getProductById() {

        System.out.print("Enter the id of the product: ");
        int id = scanner.nextInt();

        try {

            ps = getConnection().prepareStatement("SELECT * FROM products WHERE id=" + id);
            rs = ps.executeQuery();

            int productId;
            float price;
            String name;

            Product product = new Product();


            while (rs.next()) {
                productId = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getFloat("price");
                product.setName(name);
                product.setId(productId);
                product.setPrice(price);
            }

            return product;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkIfAdmin() {
        try {

            //ps = getConnection().prepareStatement("SELECT * FROM users WHERE username='" + name + "'");
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


    public static boolean addProduct() {

        if (ProductController.checkIfAdmin()) {
            System.out.print("Enter the name of the product: ");
            String name = scanner.next();

            System.out.print("Enter the price of the product: ");
            float price = scanner.nextFloat();

            try {
                ps = getConnection().prepareStatement("INSERT INTO products (name, price) VALUES('" + name + "', " + price + ")");
                ps.execute();
                return true;
            } catch (SQLException e) {
                System.out.println("Database Error");
                return false;
            }
        } else {
            System.out.println("Your role does not grant you possibility to add products");
        }
        return false;
    }

    public static void deleteProduct() {
        if (ProductController.checkIfAdmin()) {
            System.out.print("Enter the id of the product: ");
            int id = scanner.nextInt();
            try {
                ps = getConnection().prepareStatement("DELETE FROM products WHERE id=" + id);
                ps.execute();

            } catch (SQLException e) {
                System.out.println("Database Error");

            }
        } else {
            System.out.println("Your role does not grant you possibility to delete products");
        }
    }


    public static boolean editProduct() {
        if (ProductController.checkIfAdmin()) {
            System.out.println("Enter the id of the product: ");
            int id = scanner.nextInt();
            System.out.println("Enter new name:");
            String newName = scanner.next();
            System.out.println("Enter new price:");
            int newPrice = scanner.nextInt();
            try {
                ps = getConnection().prepareStatement("UPDATE products SET name ='" + newName + "' WHERE id =" + id);
                ps = getConnection().prepareStatement("UPDATE products SET price ='" + newPrice + "' WHERE id =" + id);
                ps.execute();
                return true;
            } catch (SQLException e) {
                System.out.println("Database Error");
                return false;
            }
        } else {
            System.out.println("Your role does not grant you possibility to edit products");
        }
        return false;
    }


    public static void changeCount() {
        if (ProductController.checkIfAdmin()) {
            System.out.print("Enter the id of the product: ");
            int count = scanner.nextInt();
            try {
                ps = getConnection().prepareStatement("UPDATE products SET count WHERE count=" + count);
                ps.execute();

            } catch (SQLException e) {
                System.out.println("Database Error");

            }
        } else {
            System.out.println("Your role does not grant you possibility to change count");
        }
    }




}

