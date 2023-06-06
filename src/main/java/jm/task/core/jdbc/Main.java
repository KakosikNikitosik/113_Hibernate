package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Пупа", "Иосивов", (byte) 20);
        userDao.saveUser("Лупа", "Илларионов", (byte) 25);
        userDao.saveUser("Биба", "Putin", (byte) 72);
        userDao.saveUser("Боба", "Medvedev", (byte) 50);

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
    }

