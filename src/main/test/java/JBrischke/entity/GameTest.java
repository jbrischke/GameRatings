package JBrischke.entity;

import JBrischke.persistence.GenericDao;
import JBrischke.persistence.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    GenericDao<Game> dao;

    List<Game> games;


    @BeforeEach
    void setUp() {
        testUtils.Database database = testUtils.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao<>(Game.class);
        games = dao.getAll();
    }

    @Test
    void getAllGames() {
        List<Game> games = dao.getAll();
        assertEquals(3, games.size());
    }

    @Test
    void deleteSuccess() {
        Game list = dao.getById(3);
        dao.delete(dao.getById(list.getId()));
        assertNull(dao.getById(3));

    }

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

    @Test
    void saveOrUpdate() {
        Game game = games.get(0);
        int id = game.getId();

        String updatedURl = "updatedURl";
        String updateName = "updateName";
        String updateDescription = "updateDescription";
        String updateAPIName = "updateAPIName";

        game.setGameURL(updatedURl);
        game.setName(updateName);
        game.setDescription(updateDescription);
        game.setApiName(updateAPIName);

        dao.saveOrUpdate(game);

        Game updatedUser = dao.getById(id);

        assertEquals(updatedURl, updatedUser.getGameURL());
        assertEquals(updateName, updatedUser.getName());
        assertEquals(updateDescription, updatedUser.getDescription());
        assertEquals(updateAPIName, updatedUser.getApiName());
    }

    @Test
    void getByPropertyEqualSuccess() {
        List<Game> games = dao.getByPropertyEqual("description", "Sierra");
        assertEquals(3, games.size());
    }
}