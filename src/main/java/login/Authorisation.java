package login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Authorisation {
    private static Scanner scanner = new Scanner(System.in);

    private static PreparedStatement ps;
    private static ResultSet rs;


    public static boolean singUp() {

        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password:");
        String password = scanner.nextLine();

        System.out.println("Choose your role (admin, sales person): ");
        String role = scanner.nextLine();

        if(role.equalsIgnoreCase("sales person")|| role.equalsIgnoreCase("admin")) {
            try {
                ps = getConnection().prepareStatement("INSERT INTO users(username, password, role) VALUES('" + username + "', '" + password + "', '" + role + "')");
                ps.execute();
                return true;



            } catch (SQLException e) {
                System.out.println("Username is probably already used. Choose another one.");
                System.out.println(e.getMessage());
                return false;

            }

        }else {
            System.out.println("The " + role + " is invalid. Accepted values are shown in prompt.");
            return false;
        }

    }
    public static boolean login(){
        System.out.println("Enter username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter password:");
        String loginPassword = scanner.nextLine();



        try {
            //   ps = getConnection().prepareStatement("SELECT * FROM users WHERE username = '" + loginUsername + "' and password = '" + loginPassword + "'");
            ps = getConnection().prepareStatement("SELECT * FROM users WHERE username = ?  and password = ?");
            ps.setString(1, loginUsername);
            ps.setString(2, loginPassword);

            rs= ps.executeQuery();



            if (rs.next()){

                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Invalid password or username.");
            System.out.println(e.getMessage());
            return false;

        }

    }
}



