package JBrischke.entity;

import JBrischke.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    GenericDao<User> dao;


    @BeforeEach
    void setUp() {
        dao = new GenericDao<>(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllUsers() {
        List<User> users = dao.getAll();
        assertEquals(3, users.size());
    }

    @Test
    void insert() {
        User newUser = new User();
        newUser.setUserId(500);
        newUser.setUserName("fred");
        newUser.setRole_id(1);
        newUser.setEmail("brischke1@gmail.com");
        newUser.setName("mynameisblah");
        dao.insert(newUser);

        int id = dao.insert(newUser);
        User insertedOrder = dao.getById(id);
        assertEquals("fred", insertedOrder.getUserName());
    }

    @Test
    void delete() {
        dao.delete(dao.getById(2));

    }

    @Test
    void saveOrUpdate() {
        String username = "fredy";
        User userWillUpdate = dao.getById(1);
        userWillUpdate.setUserName(username);
        dao.saveOrUpdate(userWillUpdate);
        User retrieveUser = dao.getById(1);
        assertEquals(username, retrieveUser.getUserName());
    }
}