package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private static final SessionFactory sessionFactory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        String sqlCreate = "CREATE TABLE IF NOT EXISTS users ( id INT NOT NULL AUTO_INCREMENT , " +
                " name VARCHAR(45) NULL , lastName VARCHAR(45) NULL , age TINYINT NULL , PRIMARY KEY (`id`));";
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(sqlCreate).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        String sqlDrop = "DROP TABLE IF EXISTS users;";
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(sqlDrop).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;

        System.out.println("User с именем – " + name +  " добавлен в базу данных");
        User save = new User();
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

           save.setName(name);
           save.setLastName(lastName);
           save.setAge(age);

           session.save(save);

           transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
       User user;
       Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            user = session.load(User.class, id);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {

        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User";
            Query query = session.createQuery(hql);
            List<User> users = query.list();
            for (int i = 0; i < users.size(); i++) {
                System.out.println(users.get(i));
            }
            return users;


        }
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        String sqlClean = "TRUNCATE TABLE mytestdb.users;";

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(sqlClean).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

