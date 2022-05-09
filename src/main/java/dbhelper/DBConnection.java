package dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/inventory", "postgres", "");
            if (connection != null) System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("There was a problem connection to the DB.");
        }
        return connection;
    }
}
