import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SecureDropTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check for malicious input
        if (isMaliciousInput(username) || isMaliciousInput(password)) {
            System.out.println("Warning: Malicious input detected!");
        } else {
            try {
                Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb?allowMultiQueries=true", "root", ""); 
                String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                preparedStatement.execute();


                ResultSet resultSet = preparedStatement.executeQuery();
if (resultSet.next()) {
    System.out.println("Query executed successfully!");;
} else {
    System.out.println("Invalid username or password.");
}  
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                scanner.close();
            }
        }
    }

    // Method to check for malicious input patterns
    private static boolean isMaliciousInput(String input) {
        String[] maliciousPatterns = {"'", "\"", ";", "--", "/*", "*/", "xp_"};
        for (String pattern : maliciousPatterns) {
            if (input.contains(pattern)) {
                return true;
            }
        }
        return false;
    }
}
