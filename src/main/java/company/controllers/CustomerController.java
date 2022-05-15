package company.controllers;

import company.dbhelper.DBConnection;
import company.objects.Customer;
import company.objects.Invoice;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class CustomerController {
    private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;


    public static Customer getCustomerById(){

            System.out.println("Please enter customer ID: ");
            int id = sc.nextInt();

            try {
                ps = DBConnection.getConnection().prepareStatement("SELECT * FROM customers WHERE id = " + id);
                rs = ps.executeQuery();


                int custID;
                String custName;


                Customer customer = new Customer();


                while (rs.next()) {
                    custID = rs.getInt("id");
                    custName = rs.getString("name");
                    customer.setName(custName);
                    customer.setId(custID);
                }
                return customer;

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
    }

    public static boolean addCustomer() {

        System.out.print("Enter the name of the customer: ");
        String name = sc.nextLine();
        try {
            ps = DBConnection.getConnection().prepareStatement("INSERT INTO customers (name) VALUES ('" + name + "')");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }

    }

    public static boolean deleteCustomer() {

        System.out.print("Enter the id of the customer: ");
        int id = sc.nextInt();
        try {
            ps = DBConnection.getConnection().prepareStatement("DELETE FROM customers WHERE id=" + id);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;

        }

    }

    public static boolean editCustomer() {

        System.out.println("Enter the id of the customer: ");
        int id = sc.nextInt();
        System.out.println("Enter new name:");
        String newName = sc.next();

        try {
            ps = DBConnection.getConnection().prepareStatement("UPDATE customers SET name ='" + newName + "' WHERE id =" + id);

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }

    }

    public static ArrayList<Invoice> getInvoicesByCustomerId() {


        System.out.println("Enter the id of the customer: ");
        int customersid = sc.nextInt();


        ArrayList<Invoice> invoicesList = null;
        try {
            ps = DBConnection.getConnection().prepareStatement("SELECT * FROM invoices WHERE customersid = " + customersid);
            rs = ps.executeQuery();

            System.out.println("id\t\tcustomersid\t\tdate");


            //invoicesList = new ArrayList<>();

            while (rs.next()) {

                int id = rs.getInt("id");
                String invoiceDate = rs.getString("date");



                //Invoice invoice = new Invoice(rs.getInt("id"), rs.getInt("customersid"), rs.getString("date"));
                //invoicesList.add(invoice);


                System.out.println((id + "\t\t" + customersid + "\t\t" + invoiceDate));
            }

            //return invoicesList;

        } catch (SQLException e) {

            System.out.println("get all invoices");
            e.printStackTrace();

        } return null;
    }

}
