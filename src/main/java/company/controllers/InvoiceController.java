package company.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class InvoiceController {

    //SCANNER
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    //CREATE INVOICE METHOD
    public static void createInvoice() {

        System.out.print("Enter the customers id: ");
        int customersid = scanner.nextInt();

        System.out.print("Enter the date of the invoice (DD.MM.YYYY): ");
        String invoiceDate = scanner.next();

        System.out.print("Enter the product id: ");
        int productid = scanner.nextInt();

        System.out.print("Enter the quantity of the product: ");
        int quantity = scanner.nextInt();

        int stock;
        int updateStock = 0;
        float price, sum = 0;

        try {
            ps = getConnection().prepareStatement("SELECT * FROM products WHERE id=" + productid);
            rs = ps.executeQuery();

            while (rs.next()) {
                stock = rs.getInt("stock");
                updateStock = stock - quantity;
                price = rs.getInt("price");
                sum = price * quantity;
            }

            try {
                ps = getConnection().prepareStatement("UPDATE products SET stock =" + updateStock + " WHERE id =" + productid);
                ps.execute();

            } catch (SQLException e) {
                System.out.println("Database Error");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps = getConnection().prepareStatement("INSERT INTO invoices (customersid, date, productsid, quantity, sum) VALUES(?, ?, ?, ?, ?)");
            ps.setInt(1, customersid);
            ps.setString(2, invoiceDate);
            ps.setInt(3, productid);
            ps.setInt(4, quantity);
            ps.setFloat(5, sum);
            rs = ps.executeQuery();

        } catch (SQLException e) {

        }
    }

    //DELETE INVOICE METHOD
    public static boolean deleteInvoice() {

        System.out.print("Enter the id of the invoice: ");
        int id = scanner.nextInt();
        try {
            ps = getConnection().prepareStatement("DELETE FROM invoices WHERE id=" + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }

    //EDIT INVOICE METHOD
    public static boolean editInvoice() {

        System.out.println("Enter the id of the invoice: ");
        int id = scanner.nextInt();

        System.out.println("Enter new date:");
        String newDate = scanner.next();

        try {
            ps = getConnection().prepareStatement("UPDATE products SET price ='" + newDate + "' WHERE id =" + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }

    //READ INVOICE METHOD
    public static void checkInvoices() {

        System.out.print("Enter the id of the customer: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM invoices WHERE customersid =" + id);
            rs = ps.executeQuery();

            int idInvoice, idProduct, quantity;
            String date;
            float sum;
            System.out.println("id\t\tcustomersid\t\tdate\t\tproductsid\t\tquantity\t\tsum");
            while (rs.next()) {

                idInvoice = rs.getInt("id");
                id = rs.getInt("customersid");
                date = rs.getString("date");
                idProduct = rs.getInt("productsid");
                quantity = rs.getInt("quantity");
                sum = rs.getFloat("sum");

                System.out.println(idInvoice + "\t\t" + id + "\t\t\t\t" + date
                        + "\t\t\t" + idProduct + "\t\t\t" + quantity + "\t\t" + sum);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
