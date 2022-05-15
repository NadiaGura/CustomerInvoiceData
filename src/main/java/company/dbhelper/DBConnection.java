package company.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://lallah.db.elephantsql.com/wspzjrta", "wspzjrta", "leTblWJ8WAyexkugflIA8H2KKKBNwoLE");
          //  if (connection != null) System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("There was a problem connection to the DB.");
            e.printStackTrace();
        }
        return connection;
    }
}
