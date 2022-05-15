package company.controllers;

import company.objects.Invoice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class InvoiceController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;


       /* public List<Invoice> all(){
            List<Invoice> allInvoices = new ArrayList<>();

            try {
                ps=getConnection().prepareStatement("SELECT * FROM invoices");
                rs = ps.executeQuery();

                while (rs.next()){
                    String name = rs.getString("name");
                    int id = rs.getInt("id");
                    Date date= rs.getDate("date");
                    allInvoices.add(new Invoice(id, name, date));

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                return allInvoices;
            }


        }*/

    public static void createInvoice () {

        System.out.print("Enter the customers id: ");
        int customersid = scanner.nextInt();

        System.out.print("Enter the date of the invoice (DD.MM.YYYY): ");
        String invoiceDate = scanner.next();

        System.out.print("Enter the product id: ");
        int productid = scanner.nextInt();

        System.out.print("Enter the quantity of the product: ");
        int quantity = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("INSERT INTO invoices (customersid, date, productsid, quantity) VALUES(?, ?, ?, ?)");
            ps.setInt(1, customersid);
            ps.setString(2, invoiceDate);
            ps.setInt(3, productid);
            ps.setInt(4, quantity);
            rs = ps.executeQuery();

        } catch (SQLException e) {
        //    System.out.println("Database Error");

        }

        int stock;
        int updateStock = 0;
//
//        String name = null;
    /*    try {
            ps = getConnection().prepareStatement("SELECT * FROM customers WHERE id=" + customersid);
            rs = ps.executeQuery();

            while (rs.next()) {
                name = rs.getString("name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/


//        try {
//            ps = getConnection().prepareStatement("SELECT * FROM products WHERE id=" + productid);
//            rs = ps.executeQuery();
//
//            float price, sum;
//            String nameOfProduct;
//
//            while (rs.next()) {
//            nameOfProduct = rs.getString("name");
//            price = rs.getFloat ("price");
//            sum = price*quantity;
//                System.out.println("");
//                System.out.println("Invoice created successfully:");
//                System.out.println("The date of the invoice is " + invoiceDate);
//                System.out.println("The customer name is " + name);
//                System.out.println("name\t\t\t\t\t\t\tquantity\tprice\tsum");
//                System.out.println(nameOfProduct + "\t\t" + quantity +"\t\t" + price + "\t\t" + sum);
//            }
//
//        } catch (SQLException e) {
//                    e.printStackTrace();
//        }


      /* try {
             ps = getConnection().prepareStatement("SELECT * FROM products WHERE id=" + productid);
             rs = ps.executeQuery();

             while (rs.next()) {
             stock = rs.getInt("stock");
             updateStock = stock-quantity;

             }

                  try {
                ps = getConnection().prepareStatement("UPDATE products SET stock =" + updateStock + " WHERE id =" + productid);
                ps.execute();

                          } catch (SQLException e) {
                System.out.println("Database Error");
                    }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/



//        try {
//            ps = getConnection().prepareStatement("SELECT * FROM products WHERE id=" + productid);
//            rs = ps.executeQuery();
//
//            float price, sum;
//            String nameOfProduct;
//
//            while (rs.next()) {
//            nameOfProduct = rs.getString("name");
//            price = rs.getFloat ("price");
//            sum = price*quantity;
//                System.out.println("");
//                System.out.println("Invoice created successfully:");
//                System.out.println("The date of the invoice is " + invoiceDate);
//                System.out.println("The customer name is " + name);
//                System.out.println("name\t\t\t\t\t\t\tquantity\tprice\tsum");
//                System.out.println(nameOfProduct + "\t\t" + quantity +"\t\t" + price + "\t\t" + sum);
//            }
//
//        } catch (SQLException e) {
//                    e.printStackTrace();
//        }
//
//
       try {
             ps = getConnection().prepareStatement("SELECT * FROM products WHERE id=" + productid);
             rs = ps.executeQuery();

             while (rs.next()) {
             stock = rs.getInt("stock");
             updateStock = stock-quantity;

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



    }


//    public static void getInvoice(){
//
//
//        System.out.print("Enter the product id: ");
//        int productid = scanner.nextInt();
//        System.out.print("Enter the quantity of the product: ");
//        int quantity = scanner.nextInt();
//
//        try {
//            ps = getConnection().prepareStatement("SELECT * FROM products WHERE id=" + productid);
//            rs = ps.executeQuery();
//
//            float price, sum;
//            String name;
//
//            System.out.println("name\t\t\t\t\t\t\t\t\t\tquantity\t\tprice\t\t\tsum");
//            while (rs.next()) {
//
//
//                name = rs.getString("name");
//                price = rs.getFloat ("price");
//                sum = price*quantity;
//
//
//                System.out.println(name
//                        + "\t\t" + quantity +"\t\t" + price + "\t\t" + sum);
//
//            }
//
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
//
//    }
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


    public static boolean editInvoice() {

        System.out.println("Enter the id of the invoice: ");
        int id = scanner.nextInt();

     //   System.out.println("Enter new customersid:");
     //     int newCustomersId = scanner.nextInt();

        System.out.println("Enter new date:");
        String newDate = scanner.next();

        try {
         //   ps = getConnection().prepareStatement("UPDATE invoices SET customersid ='" + newCustomersId + "' WHERE id =" + id);
            ps = getConnection().prepareStatement("UPDATE products SET price ='" + newDate + "' WHERE id =" + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }

    }

    public static void checkInvoices(){

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
                idProduct= rs.getInt("productsid");
                quantity = rs.getInt("quantity");
                sum = rs.getFloat("sum");

                System.out.println(idInvoice + "\t\t" + id+ "\t\t\t\t" + date
                        + "\t\t\t\t" + idProduct + "\t\t\t" + quantity + "\t\t\t" + sum);

            }



        } catch (SQLException e) {
            e.printStackTrace();

        }

    }



}
