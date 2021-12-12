package modul_1;

import java.sql.*;

public class ModulJDBC1 {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String USER = "miki";
    private static final String PASS = "123456";

    public static String conect(String DB_URL, String USER, String PASS) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
              Statement statement = connection.createStatement()){
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("Class " + JDBC_DRIVER + " not found");
            }
        }

        return Sta
    }


    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("Class " + JDBC_DRIVER + " not found");
                return;
            }

            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM test where  cash < 5000")) {
                while (resultSet.next()) {
                    // показывает данные обьектов первой колонки в таблице(если колонка int)
                    //System.out.println(resultSet.getInt(1));
                    // показывает данные обьектов первой колонки в таблице(если колонка string)
                    //System.out.println(resultSet.getString(2));
                    //---------------------
                    long id = resultSet.getLong(1);
                    String city = resultSet.getString(2);
                    int cash = resultSet.getInt(3);
                    Test test = new Test(id, city, cash);
                    System.out.println(test);
                    //---------------------
                    /*int id = resultSet.getInt("id");
                    System.out.println("Object found = " + id);*/
                }
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }
}
