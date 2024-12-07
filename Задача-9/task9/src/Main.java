import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // Получаем экземпляр менеджера подключений
        DatabaseConnectionManager manager = DatabaseConnectionManager.getInstance();

        // Получаем соединение
        Connection connection = manager.getConnection();

        // Используем соединение
        if (connection != null) {
            System.out.println("Соединение с базой данных успешно установлено.");
        }

        // Закрываем соединение
        manager.closeConnection();
        System.out.println("Соединение с базой данных закрыто.");
    }
}