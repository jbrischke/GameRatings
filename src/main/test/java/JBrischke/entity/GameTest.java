package JBrischke.entity;

import JBrischke.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Game test.
 */
class GameTest {

    /**
     * The Dao.
     */
    GenericDao<Game> dao;

    /**
     * The Games.
     */
    List<Game> games;


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao<>(Game.class);
        games = dao.getAll();
    }

    /**
     * Gets all games.
     */
    @Test
    void getAllGames() {
        //gets back a list of all the dbclean.sql file = 3
        List<Game> games = dao.getAll();
        assertEquals(3, games.size());
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        Game list = dao.getById(3);
        dao.delete(dao.getById(list.getId()));
        assertNull(dao.getById(3));

    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        Game newGame = new Game("url", "name", "apiname", "description");
        Report newReport = new Report("description", 11);
        newGame.addReport(newReport);

        int id = dao.insert(newGame);

        assertNotEquals(0,id);
        Game insertedGame = dao.getById(id);
        assertEquals("name", insertedGame.getName());
        assertEquals("url", insertedGame.getGameURL());
        assertEquals("apiname", insertedGame.getApiName());
        assertEquals("description", insertedGame.getDescription());
        assertEquals(1, insertedGame.getReports().size());
    }

    /**
     * Save or update.
     */
    @Test
    void saveOrUpdate() {
        Game game = games.get(0);
        int id = game.getId();

        //sets new entries for the update
        String updatedURl = "updatedURl";
        String updateName = "updateName";
        String updateDescription = "updateDescription";
        String updateAPIName = "updateAPIName";

        //sets new values for this entity
        game.setGameURL(updatedURl);
        game.setName(updateName);
        game.setDescription(updateDescription);
        game.setApiName(updateAPIName);

        //updates an existing game
        dao.saveOrUpdate(game);

        //grabs the updated user that is equal to the original id
        Game updatedUser = dao.getById(id);

        assertEquals(updatedURl, updatedUser.getGameURL());
        assertEquals(updateName, updatedUser.getName());
        assertEquals(updateDescription, updatedUser.getDescription());
        assertEquals(updateAPIName, updatedUser.getApiName());
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        //checks to see if information can be obtained by a specific description
        List<Game> games = dao.getByPropertyEqual("description", "Sierra");
        assertEquals(3, games.size());
    }
}