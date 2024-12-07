import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/my_database";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private DatabaseConnectionManager() {
        try {
            // Регистрация драйвера
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Драйвер MySQL не найден", e);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при подключении к базе данных: " + e.getMessage(), e);
        }
    }

    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionManager.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionManager();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Ошибка при закрытии соединения", e);
            }
        }
    }
}