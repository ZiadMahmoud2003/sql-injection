import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class SDrop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            // Connect to the database with allowMultiQueries enabled
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb?allowMultiQueries=true", "root", ""); // Replace with your MySQL password
            Statement statement = connection.createStatement();
            // Vulnerable query
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            System.out.println("Executing query: " + query);
            // Execute the query
            statement.execute(query);
            System.out.println("Query executed successfully!");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
