package company.controllers;

import company.objects.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class CustomerController {
    private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;


    public static Customer getCustomerById(){

            System.out.println("Please enter customer ID: ");
            int id = sc.nextInt();

            System.out.println("Enter name of the customer: ");
            String name = sc.next();

            try {
                ps = getConnection().prepareStatement("SELECT * FROM customers WHERE id = " + id);
                rs = ps.executeQuery();


                int custID;
                String custName;


                Customer customer = new Customer();


                while (rs.next()) {
                    custID = rs.getInt("id");
                    custName = rs.getString("name");
                    customer.setName(name);
                    customer.setId(id);
                }
                return customer;

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
    }

    public static boolean addCustomer() {

        System.out.print("Enter the name of the costumer: ");
        String name = sc.nextLine();

        try {
            ps = getConnection().prepareStatement("INSERT INTO customer (name) VALUES(?)");
            ps.setString(1, name);
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
            ps = getConnection().prepareStatement("DELETE FROM customers WHERE id=" + id);
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
        String newName = sc.nextLine();

        try {
            ps = getConnection().prepareStatement("UPDATE products SET name ='" + newName + "' WHERE id =" + id);

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }

    }




}
