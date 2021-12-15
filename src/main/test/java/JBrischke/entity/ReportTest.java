package JBrischke.entity;

import JBrischke.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Report test.
 */
class ReportTest {
    /**
     * The Dao.
     */
    GenericDao<Report> dao;


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao<>(Report.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Gets all roles.
     */
    @Test
    void getAllRoles() {
        //returns the 6 sample reports added from the cleansql.db = 6
        List<Report> reports = dao.getAll();
        assertEquals(6, reports.size());
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        //checks to see if this entity can be used to return objects by a specific description
        List<Report> reports = dao.getByPropertyEqual("description", "entry1");
        assertEquals(2, reports.size());
    }
}