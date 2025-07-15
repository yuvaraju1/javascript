import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloWorldVulnerabilities {

    // Example 1: Hardcoded password vulnerability
    private static String hardcodedPassword = "mySecretPassword";

    // Example 2: SQL Injection vulnerability
    public static void sqlInjectionVulnerability(String userInput) {
        try {
            // Simulate an insecure SQL query with user input (SQL Injection)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + userInput + "';";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Example 3: Weak password storage
    public static void weakPasswordStorage() {
        try {
            // Save a password in plaintext (weak password storage)
            String password = "plainTextPassword123";
            // Simulating saving the password in a file or database
            System.out.println("Password saved: " + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example 1: Hardcoded password
        System.out.println("Hardcoded password: " + hardcodedPassword);

        // Example 2: SQL Injection
        sqlInjectionVulnerability("admin' OR '1'='1");

        // Example 3: Weak password storage
        weakPasswordStorage();
    }
}
