package JBrischke.entity;

import JBrischke.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User test.
 */
class UserTest {

    /**
     * The Dao.
     */
    GenericDao<User> dao;


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao<>(User.class);
    }

    /**
     * Gets all users.
     */
    @Test
    void getAllUsers() {
        //gets a user list of all the inserted users from the cleandb.sql = 3
        List<User> users = dao.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Insert with user success.
     */
    @Test
    void insertWithUserSuccess() {
        //creates a new user entity and assigns information to it
        User newUser = new User("Susan", "email@gmail.com", "fflintstone");

        //the default user role upon sign in
        String roleName = "user";

        //creates a role tntity and uses the constructor to insert a new role
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

    /**
     * Save or update.
     */
    @Test
    void saveOrUpdate() {
        //the other role type for users
        String role_name = "admin";

        //returns a entity of user by the id of 1
        User userWillUpdate = dao.getById(1);

        //loops through the existing role entity and sets a new rolename
        Set<Role> role = userWillUpdate.getRoles();
        for(Role roleTypes : role) {
            roleTypes.setRoleName(role_name);
        }

        //checks to see that the new role name is the one specified above
        dao.saveOrUpdate(userWillUpdate);
        Set<Role> roleCheck = userWillUpdate.getRoles();
        for(Role roleTypes : roleCheck) {
            assertEquals(role_name, roleTypes.getRoleName());
        }
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        //validates that a username can be used to validate other information
        List<User> users = dao.getByPropertyEqual("userName", "Josh");
        assertEquals(1, users.size());
    }
}