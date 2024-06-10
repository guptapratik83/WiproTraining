package JDBC;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class InsertUser {

    public static void main(String[] args) {
        String userId = "exampleUser";
        String password = "examplePassword";

        try {
            String passwordHash = generateHash(password);

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro_test", "root", "rps@2345");
            String query = "INSERT INTO User (UserID, PasswordHash) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, userId);
            pstmt.setString(2, passwordHash);
            pstmt.executeUpdate();

            System.out.println("User inserted successfully.");
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
