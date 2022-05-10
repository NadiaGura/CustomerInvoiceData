package company.controllers;

import company.objects.Invoice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static company.dbhelper.DBConnection.getConnection;

public class InvoiceController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean createInvoice(){
        System.out.print("Enter the customers id: ");
        int customersid = scanner.nextInt();

        System.out.print("Enter the date of the invoice: ");
        String  invoiceDate = scanner.next();

        System.out.print("Enter the date of the invoice: ");
        float  sum = scanner.nextFloat();



        try {
            ps = getConnection().prepareStatement("INSERT INTO invoices (customersid, date, sum) VALUES(?, ?, ?)");
            ps.setInt(1, customersid);
            ps.setString(2, invoiceDate);
            ps.setFloat(3, sum);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }


}

}
