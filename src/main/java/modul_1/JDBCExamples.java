package modul_1;

import java.sql.*;

public class JDBCExamples {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String USER = "miki";
    private static final String PASS = "123456";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {

            /*boolean res = statement.execute("insert into product (id, name, description, price)" + "values (2, 'toy111', 'for children', 60)");
            System.out.println(res);*/
            /*boolean res = statement.execute("insert into product values (2, 'toy111', 'for childrean', 60)");
            System.out.println(res);*/

            /*int res = statement.executeUpdate("insert into product values (3, 'bike', 'for woman', 150)");
            System.out.println(res);
            int res1 = statement.executeUpdate("insert into product values (4, 'car', 'for man', 770)");
            System.out.println(res1);*/

            /*boolean res = statement.execute("delete from product where name = 'toy111'");
            System.out.println(res);*/
            /*int res = statement.executeUpdate("delete from product where  name = 'car'");
            System.out.println(res);*/

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }
}
