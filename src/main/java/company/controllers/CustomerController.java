package company.controllers;

import company.dbhelper.DBConnection;
import company.objects.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class CustomerController {

    //SCANNER
    private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    //GET CUSTOMER BY ID METHOD
    public static Customer getCustomerById() {

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

    //ADD CUSTOMER METHOD
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

    //DELETE CUSTOMER METHOD
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

    //EDIT CUSTOMER METHOD
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
}
