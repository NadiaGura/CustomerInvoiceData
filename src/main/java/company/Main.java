package company;

import company.controllers.*;
import company.dbhelper.DBConnection;
import company.login.Authorisation;
import company.menu.AdminsMenu;
import company.objects.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        DBConnection.getConnection();
//
       // Authorisation.signUp();
        //UsersController.deleteUser();
        //ProductController.addProduct();
      //  Authorisation.login();


       // SalesPersonMenu.menu();

//        AdminsMenu.menu();

       // ProductController.checkInventory();


        // To get customers name by ID
//        System.out.println(CustomerController.getCustomerById().getName());


        InvoiceController.createInvoice();

//        System.out.println(UsersController.checkIfAdmin() ? "Admin" : "Not admin");
 //       InvoiceLineController.addInvoiceLine();

    //    System.out.println(ProductController.getProductById().getName());


       // ProductController.editProduct();




    }
}
