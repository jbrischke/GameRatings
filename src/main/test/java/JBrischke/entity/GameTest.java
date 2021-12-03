package JBrischke.entity;

import JBrischke.persistence.GenericDao;
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
}