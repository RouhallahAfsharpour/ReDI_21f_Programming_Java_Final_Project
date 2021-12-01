package GroceriesApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//RA: this is for using real database instead of CSV file. but we need to talk to teachers about it first
public class MyJDBC {
    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://192.100.0.000:3306/MyDBGroceries", "root", "root");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from registerdUsers");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
