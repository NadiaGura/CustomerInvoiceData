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
//            Invoice inv = new Invoice();
//            try {
//                ps = getConnection().prepareStatement("INSERT INTO invoices (id, name, date) values (?, ?, ?");
//                ps.setInt(1, inv.getId());
//                ps.setString(2, inv.getCustomer());
//                ps.setDate(3, inv.getDate());
//                ps.execute();
//
//            } catch (SQLException e) {
//              //  throw new RuntimeException(e);
//            }
//        }


        System.out.print("Enter the customers id: ");
        int customersid = scanner.nextInt();

        System.out.print("Enter the date of the invoice: ");
        String invoiceDate = scanner.next();

        try {
            ps = getConnection().prepareStatement("INSERT INTO invoices (customersid, date) VALUES(?, ?)");
            ps.setInt(1, customersid);
            ps.setString(2, invoiceDate);
            rs = ps.executeQuery();



        } catch (SQLException e) {
            System.out.println("Database Error");

        }

            System.out.print("Enter the product id: ");
            int productid = scanner.nextInt();
            System.out.print("Enter the quantity of the product: ");
            int quantity = scanner.nextInt();

            try {
                ps = getConnection().prepareStatement("SELECT * FROM products WHERE id=" + productid);
                rs = ps.executeQuery();

                float price, sum;
                String name;
                System.out.println("Invoice created successfully:");
                System.out.println("name\t\t\t\t\t\t\tquantity\tprice\tsum");
                while (rs.next()) {


                    name = rs.getString("name");
                    price = rs.getFloat ("price");
                    sum = price*quantity;


                    System.out.println(name
                            + "\t\t" + quantity +"\t\t" + price + "\t\t" + sum);

                }



            } catch (SQLException e) {
                e.printStackTrace();

            }

            System.out.println("The date of the invoice is " + invoiceDate);
            System.out.println("The customer id is " + customersid);



}


    public static void getInvoice(){


        System.out.print("Enter the product id: ");
        int productid = scanner.nextInt();
        System.out.print("Enter the quantity of the product: ");
        int quantity = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM products WHERE id=" + productid);
            rs = ps.executeQuery();

            float price, sum;
            String name;

            System.out.println("name\t\t\t\t\t\t\t\t\t\tquantity\t\tprice\t\tsum");
            while (rs.next()) {


                name = rs.getString("name");
                price = rs.getFloat ("price");
                sum = price*quantity;


                System.out.println(name
                        + "\t\t" + quantity +"\t\t" + price + "\t\t" + sum);

            }



        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
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

}
