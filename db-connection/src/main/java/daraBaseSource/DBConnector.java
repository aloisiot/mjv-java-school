package daraBaseSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static Connection connection;

    private static void startUp() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mjv",
                "user_test",
                "test123"
        );
    }

    public static Connection getConnection() throws SQLException {
        if(connection == null) {
            startUp();
        }
        return connection;
    }
}
