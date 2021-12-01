package persistence;

import JBrischke.entity.*;
import testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import JBrischke.persistence.GenericDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The type Admin dao test.
 */
class AdminDaoTest {

    /**
     * The Dao.
     */
    GenericDao<Game> gameGenericDao = new GenericDao<>(Game.class);

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        gameGenericDao = new GenericDao<>(Game.class);
    }

    /**
     * Gets all games.
     */
    @Test
    void getAllGames() {

        List<Game> Games = gameGenericDao.getAll();
        assertEquals(3, Games.size());
    }

    /**
     * Insert.
     */
    @Test
    void insert() {
        Game newGame = new Game();
        newGame.setId(10);
        newGame.setGameURL("https://www.enjpg.com/img/2020/cool-for-boys-4.jpg");
        newGame.setDescription("test will pass");
        gameGenericDao.insert(newGame);

        int id = gameGenericDao.insert(newGame);

        assertNotEquals(0,id);
        Game insertedOrder = gameGenericDao.getById(id);
        assertEquals("https://www.enjpg.com/img/2020/cool-for-boys-4.jpg", insertedOrder.getGameURL());
        assertNotNull(insertedOrder.getDescription());
    }

    /**
     * Delete.
     */
    @Test
    void delete() {
        gameGenericDao.delete(gameGenericDao.getById(1));
        assertNull(gameGenericDao.getById(1));
    }

    /**
     * Save or update.
     */
    @Test
    void saveOrUpdate() {
        String description = "test will pass";
        Game gameWillUpdate = gameGenericDao.getById(2);
        gameWillUpdate.setDescription(description);
        gameGenericDao.saveOrUpdate(gameWillUpdate);
        Game retrievedBook = gameGenericDao.getById(2);
        assertEquals(description, retrievedBook.getDescription());
    }
}