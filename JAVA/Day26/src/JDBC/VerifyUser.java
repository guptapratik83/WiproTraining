package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class VerifyUser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter UserID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        try {
            String passwordHash = generateHash(password);

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro_test", "root", "rps@2345");
            String query = "SELECT * FROM User WHERE UserID = ? AND PasswordHash = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, userId);
            pstmt.setString(2, passwordHash);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("User authenticated successfully.");
            } else {
                System.out.println("Invalid UserID or Password.");
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String generateHash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
