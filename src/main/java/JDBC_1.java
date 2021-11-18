import java.sql.*;

public class JDBC_1 {
    // DB driver
    // create connection
    // create query
    // execute query
    // work with result
    // close all the connection

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/nikzim";

    private static final String USER = "postgres";
    private static final String PASS = "648992wiki23Q1";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("Class " + JDBC_DRIVER + " not found");
                return;
            }

            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM test")) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    System.out.println("Object found = " + id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }
}



