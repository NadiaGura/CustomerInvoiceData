package company;

import  static company.dbhelper.DBConnection.getConnection;

import company.controllers.*;
import company.dbhelper.DBConnection;
import company.login.Authorisation;
import company.menu.AdminsMenu;
import company.menu.WelcomeMenu;
import company.objects.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WelcomeMenu.menu();



    }
}
