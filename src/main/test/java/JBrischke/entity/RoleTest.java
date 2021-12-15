package JBrischke.entity;

import JBrischke.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Role test.
 */
class RoleTest {
    /**
     * The Dao.
     */
    GenericDao<Role> dao;


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao<>(Role.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Gets all roles.
     */
    @Test
    void getAllRoles() {
        //checks to see if 3 roles were added to the database = 3 total
        List<Role> roles = dao.getAll();
        assertEquals(3, roles.size());
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        //checks that role name can be used to grab a specific level of autherization
        List<Role> roles = dao.getByPropertyEqual("roleName", "user");
        assertEquals(3, roles.size());
    }
}