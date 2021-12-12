package modul_1.hw;

import javax.management.Descriptor;
import java.sql.*;

public class Solution {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "miki";
    private static final String PASS = "123456";

    public static void main(String[] args) {
        System.out.println(getAllProductsQ());

    }


    public static int getAllProductsQ() {
        int resp = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from product");
            while (resultSet.next()) {
                resp = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("wrong class Solution");
            e.printStackTrace();
        }
        return resp;
    }

    public void getAllProducts() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            int res = statement.executeUpdate("select * from product");
        } catch (SQLException e) {
            System.err.println("WRONG getAllProducts");
            e.printStackTrace();
        }
    }

    public void getProductsByPrice() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            int res = statement.executeUpdate("select * from product where price <= 100");
        } catch (SQLException e) {
            System.err.println("WRONG getProductsByPrice");
            e.printStackTrace();
        }
    }

    public void getProductsByDescription() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            int res = statement.executeUpdate("select * from product where  length(description) > 50");
        } catch (SQLException e) {
            System.err.println("WRONG getProductsByDescription");
            e.printStackTrace();
        }
    }

    public void increasePrice() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            int res = statement.executeUpdate("update product set price = price +100 where price < 970");
        } catch (SQLException e) {
            System.err.println("WRONG increasePrice");
            e.printStackTrace();
        }
    }

    public void changeDescriptor() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            int res = statement.executeUpdate("update product set description = substring(description, position(description, ',', -1)-1) where length(description) > 100 ");
        } catch (SQLException e) {
            System.err.println("WRONG changeDescriptor");
        }
    }
}
