package JBrischke.entity;

import JBrischke.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserTest {

    GenericDao<User> dao;


    @BeforeEach
    void setUp() {

        testUtils.Database database = testUtils.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao<>(User.class);
    }

    @Test
    void getAllGames() {
        List<User> users = dao.getAll();
        assertEquals(1, users.size());
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
        assertEquals("mynameisblah", insertedOrder.getName());
    }



}