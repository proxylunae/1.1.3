package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        System.out.println("Таблица users создана (если её не было)");
        User kuko = new User("Kuko", "Ku", (byte) 12);
        User kuku = new User("Kuku", "Ku", (byte) 13);
        User kuky = new User("Kuky", "Ku", (byte) 14);
        userDaoJDBC.saveUser(kuko.getName(), kuko.getLastName(), kuko.getAge());
        userDaoJDBC.saveUser(kuku.getName(), kuku.getLastName(), kuku.getAge());
        userDaoJDBC.saveUser(kuky.getName(), kuky.getLastName(), kuky.getAge());
        List<User> users = userDaoJDBC.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        userDaoJDBC.cleanUsersTable();
        users = userDaoJDBC.getAllUsers();
        System.out.println("Размер списка после очистки: " + users.size());
    }
}
