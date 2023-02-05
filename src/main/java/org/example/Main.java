package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/postgres";

        String username = "postgres";

        String password = "ZAPlmk2014";

        String conok="Соединение с бд установлено";
        String conerr="Произошла ошибка подключения к бд";

        try (Connection connection = DriverManager.getConnection(URL, username, password)){
            System.out.println(String.format("%s",conok));
        } catch (SQLException e) {
            System.out.println(String.format("%s",conerr));
            e.printStackTrace();
        }
    }
}