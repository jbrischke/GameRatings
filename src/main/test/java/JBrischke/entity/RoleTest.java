package JBrischke.entity;

import JBrischke.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {
    GenericDao<Role> dao;


    @BeforeEach
    void setUp() {
        dao = new GenericDao<>(Role.class);
        testUtils.Database database = testUtils.Database.getInstance();
        database.runSQL("cleandb.sql");
    }

}