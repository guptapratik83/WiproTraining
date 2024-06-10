package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUserTable {

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro_test", "root", "rps@2345");
             Statement stmt = con.createStatement()) {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS User (" +
                                    "UserID VARCHAR(255) PRIMARY KEY, " +
                                    "PasswordHash CHAR(64) NOT NULL)";

            stmt.execute(createTableSQL);
            System.out.println("User table created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
