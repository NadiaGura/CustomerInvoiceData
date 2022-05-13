package company.controllers;

import company.dbhelper.DBConnection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class InvoiceLineController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;


//    public static void addInvoiceLine() {
//
//
//        System.out.print("Enter the invoice id: ");
//        int invoiceid = scanner.nextInt();
//        System.out.print("Enter the product id: ");
//        int productid = scanner.nextInt();
//        System.out.print("Enter the quantity of the product: ");
//        int quantity = scanner.nextInt();
//
//        try {
//            ps = getConnection().prepareStatement("INSERT INTO invoicelines (invoiceid, productid, quantity)" +
//                    " VALUES(" + invoiceid + "," + productid + "," + quantity + ")");
//            ps.execute();
//
//
//            ps = getConnection().prepareStatement("SELECT * FROM products WHERE id=" + productid);
//            rs = ps.executeQuery();
//
//            float price;
//
//            float sum = 0;
//            while (rs.next()) {
//                price = rs.getFloat("price");
//                sum = price * quantity;
//                ps = getConnection().prepareStatement("INSERT INTO invoicelines (sum) VALUES" + sum + ")");
//                ps.execute();
//            }
//
//
//        } catch(SQLException e){
//                System.out.println("Database Error");
//
//            }
//
//        }


    public static void getInvoiceLine(){


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

    public static boolean addInvoiceLine (int invoiceID, int countOfLines) {


        System.out.print("Enter the id of the product: ");
        int id = scanner.nextInt();
        System.out.print("Enter the quantity of the product: ");
        int quantity = scanner.nextInt();

        try {
            ps = DBConnection.getConnection().prepareStatement("INSERT INTO invoicelines (quantity) VALUES(" + quantity + "WHERE id=" + id);
            ps.execute();

        } catch (SQLException e) {
            System.out.println("Database Error");

        }

        return false;
    }


    }

