package JBrischke.entity;

import JBrischke.persistence.GenericDao;
import JBrischke.persistence.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    GenericDao<Game> dao;


    @BeforeEach
    void setUp() {

        testUtils.Database database = testUtils.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao<>(Game.class);
    }

    @Test
    void getAllGames() {
        List<Game> games = dao.getAll();
        assertEquals(3, games.size());
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Returns an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }


}