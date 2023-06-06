package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/mytestdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root1234";
    public static Connection getConnection() {
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Connection succesfull!");
        } catch(ClassNotFoundException | SQLException ex){
            System.out.println("Connection failed...");
        }
        return connection;
    }
}
