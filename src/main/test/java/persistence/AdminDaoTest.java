package persistence;

import JBrischke.entity.*;
import testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import JBrischke.persistence.GenericDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class AdminDaoTest {


    GenericDao<User> userGenericDao;


    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        userGenericDao = new GenericDao<>(User.class);
    }

}
