package org.example;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/postgres";

        String username = "postgres";

        String password = "ZAPlmk2014";

        String conok="Соединение с бд установлено";
        String conerr="Произошла ошибка подключения к бд";
        Connection connection = null;
        try  {
            connection = DriverManager.getConnection(URL, username, password);
            System.out.println(String.format("%s",conok));
        } catch (SQLException e) {
            System.out.println(String.format("%s",conerr));
            e.printStackTrace();
        }

        int count = 2;
        String SQL = "Select * from test WHERE id = ?;";
        try  {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, count);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}