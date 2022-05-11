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


    public static boolean addProduct() {


            System.out.print("Enter the name of the product: ");
            String name = scanner.next();

            System.out.print("Enter the price of the product: ");
            float price = scanner.nextFloat();

            System.out.print("Enter quantity of the product: ");
            int quantity = scanner.nextInt();

            try {
                ps = getConnection().prepareStatement("INSERT INTO products (name, price, quantity)" +
                        "VALUES('" + name + "', " + price + ", " + quantity + ")");
                ps.execute();
                return true;

            } catch (SQLException e) {
                System.out.println("Database Error");
                return false;
            }
        }


    public static void deleteProduct() {

            System.out.print("Enter the id of the product: ");
            int id = scanner.nextInt();
            try {
                ps = getConnection().prepareStatement("DELETE FROM products WHERE id=" + id);
                ps.execute();

            } catch (SQLException e) {
                System.out.println("Database Error");

            }
    }


    public static void editProduct() {

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

            } catch (SQLException e) {
                System.out.println("Database Error");

            }
        }



    public static void changeQuantity() {

            System.out.print("Enter the id of the product: ");
            int quantity = scanner.nextInt();
            try {
                ps = getConnection().prepareStatement("UPDATE products SET count WHERE quantity=" + quantity + ")");
                ps.execute();

            } catch (SQLException e) {
                System.out.println("Database Error");

            }
        }


}






