package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
public class UserDaoJDBCImpl implements UserDao {
    //Connection connection = Util.getConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS users ( id INT NOT NULL AUTO_INCREMENT , " +
                " name VARCHAR(45) NULL , lastName VARCHAR(45) NULL , age TINYINT NULL , PRIMARY KEY (`id`));";

        try (Statement createStatement = connection.createStatement()) {
            createStatement.executeUpdate(sqlCreate);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sqlDrop = "DROP TABLE IF EXISTS users;";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlDrop);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sqlSave = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?);";
        System.out.println("User с именем – " + name +  " добавлен в базу данных");

        try (PreparedStatement prStatement = connection.prepareStatement(sqlSave)) {
            //statement.executeUpdate(sqlSave);
            prStatement.setString(1, name);
            prStatement.setString(2, lastName);
            prStatement.setByte(3, age);

            prStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sqlRemove = "DELETE FROM mytestdb.users WHERE id = ?;";


        try (PreparedStatement prStatement = connection.prepareStatement(sqlRemove)) {
            prStatement.setLong(1, id);
            prStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();

        String sqlGetAll = "SELECT id, name, lastName, age FROM mytestdb.users";

        try (PreparedStatement prStatement = connection.prepareStatement(sqlGetAll)) {
            ResultSet resultSet = prStatement.executeQuery(sqlGetAll);
            while (resultSet.next()) {
                User users = new User();
                users.setId(resultSet.getLong("id"));
                users.setName(resultSet.getString("name"));
                users.setLastName(resultSet.getString("lastName"));
                users.setAge(resultSet.getByte("age"));

                usersList.add(users);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(usersList);
        return usersList;
    }

    public void cleanUsersTable() {
        String sqlClean = "TRUNCATE TABLE mytestdb.users;";


        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlClean);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/
