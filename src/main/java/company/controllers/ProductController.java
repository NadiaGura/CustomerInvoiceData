package company.controllers;

import company.dbhelper.DBConnection;
import company.objects.Customer;
import company.objects.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            String name = scanner.nextLine();

            System.out.print("Enter the price of the product: ");
            float price = scanner.nextFloat();

            System.out.print("Enter the quantity of the product to add: ");
            int quantity = scanner.nextInt();

            try {
                ps = DBConnection.getConnection().prepareStatement("INSERT INTO products (name, price, quantity) VALUES(?, ?, ?)");
                ps.setString(1, name);
                ps.setFloat(2, price);
                ps.setInt(3, quantity);
                ps.execute();
                return true;
            } catch (SQLException e) {
                System.out.println("Database Error");
                return false;
            }

    }

    public static boolean deleteProduct() {

            System.out.print("Enter the id of the product: ");
            int id = scanner.nextInt();
            try {
                ps = getConnection().prepareStatement("DELETE FROM products WHERE id=" + id);
                ps.execute();
                return true;

            } catch (SQLException e) {
                System.out.println("Database Error");
                return false;

            }

    }


    public static boolean editProduct() {

            System.out.println("Enter the id of the product: ");
            int id = scanner.nextInt();
            System.out.println("Enter new name:");
            String newName = scanner.next();
            System.out.println("Enter new price:");
            float newPrice = scanner.nextFloat();
            try {
                ps = getConnection().prepareStatement("UPDATE products SET name ='" + newName + "' WHERE id =" + id);
                ps.execute();
                ps = getConnection().prepareStatement("UPDATE products SET price =" + newPrice + " WHERE id =" + id);
                ps.execute();
                return true;
            } catch (SQLException e) {
                System.out.println("Database Error");
                return false;
            }

    }


    public static void changeQuantity() {

            System.out.print("Enter the id of the product: ");
            int id = scanner.nextInt();

            System.out.println("Enter new quantity:");
            int newQuantity = scanner.nextInt();



            try {
                ps = getConnection().prepareStatement("UPDATE products SET quantity = '" + newQuantity + "' WHERE id=" + id);
                ps.execute();

            } catch (SQLException e) {
                System.out.println("Database Error");

            }

    }

//    public static void checkInventory() {
//
//
//        try { ps = getConnection().prepareStatement("SELECT * FROM products");
//            ps.executeQuery();
//            while (rs.next()) {
//
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                float price = rs.getFloat("price");
//                int quantity = rs.getInt("quantity");
//
//                Product obj = new Product();
//                obj.setId(id);
//                obj.setName(name);
//                obj.setPrice(price);
//                obj.setQuantity(quantity);
//
//
//                System.out.println(obj);
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Database Error");
//
//        }
//
//
//    }



    public static void checkInventory(){

        try {
            ps = getConnection().prepareStatement("SELECT * FROM products");
            rs = ps.executeQuery();


            int id, quantity;
            String name;
            float price;
            System.out.println("id\t\tname\t\tprice\t\tquantity");
            while (rs.next()) {

                id = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getFloat("price");
                quantity = rs.getInt("quantity");

                System.out.println(id + "\t\t" + name
                        + "\t\t" + price + "\t\t" + quantity );

            }



        } catch (SQLException e) {
            e.printStackTrace();

        }

    }





}

