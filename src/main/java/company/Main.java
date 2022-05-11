package company;

import company.controllers.ProductController;
import company.controllers.UsersController;
import company.dbhelper.DBConnection;
import company.login.Authorisation;
import company.menu.AdminsMenu;

public class Main {
    public static void main(String[] args) {

//        DBConnection.getConnection();
//
       // Authorisation.signUp();
        //UsersController.deleteUser();
        //ProductController.addProduct();
      //  Authorisation.login();


       // SalesPersonMenu.menu();

        AdminsMenu.menu();

       // ProductController.checkInventory();







    }
}
