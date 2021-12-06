package JBrischke.entity;

import JBrischke.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    GenericDao<User> dao;


    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao<>(User.class);
    }

    @Test
    void getAllUsers() {
        List<User> users = dao.getAll();
        assertEquals(3, users.size());
    }

    @Test
    void insert() {
        User newUser = new User();
        newUser.setUser_id(500);
        newUser.setUserName("fred");
        newUser.setEmail("brischke1@gmail.com");
        newUser.setName("mynameisblah");
        dao.insert(newUser);

        int id = dao.insert(newUser);
        User insertedOrder = dao.getById(id);
        assertEquals("fred", insertedOrder.getUserName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertWithOrderSuccess() {
        User newUser = new User("Susan", "email@gmail.com", "fflintstone");

        String roleName = "user";
        Role role = new Role(roleName, newUser.getUserName(), newUser);

        newUser.addRole(role);

        int id = dao.insert(newUser);

        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("Susan", insertedUser.getName());
        assertEquals("email@gmail.com", insertedUser.getEmail());
        assertEquals("fflintstone", insertedUser.getUserName());
        assertEquals(1, insertedUser.getRoles().size());
    }

    @Test
    void saveOrUpdate() {

        String role_name = "admin";
        User userWillUpdate = dao.getById(1);
        Set<Role> role = userWillUpdate.getRoles();
        for(Role roleTypes : role) {
            roleTypes.setRoleName(role_name);
        }

        dao.saveOrUpdate(userWillUpdate);
        Set<Role> roleCheck = userWillUpdate.getRoles();
        for(Role roleTypes : roleCheck) {
            assertEquals(role_name, roleTypes.getRoleName());
        }
    }

    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("userName", "Josh");
        assertEquals(1, users.size());
    }
}