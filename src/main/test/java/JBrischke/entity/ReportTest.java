package JBrischke.entity;

import JBrischke.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {
    GenericDao<Report> dao;


    @BeforeEach
    void setUp() {
        dao = new GenericDao<>(Report.class);
        testUtils.Database database = testUtils.Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllRoles() {
        List<Report> reports = dao.getAll();
        assertEquals(6, reports.size());
    }

    @Test
    void getByPropertyEqualSuccess() {
        List<Report> reports = dao.getByPropertyEqual("description", "entry1");
        assertEquals(2, reports.size());
    }
}