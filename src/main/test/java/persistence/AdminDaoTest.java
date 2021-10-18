package persistence;

import entity.Game;
import testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class AdminDaoTest {

    AdminDao dao;

    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new AdminDao();
    }

    @Test
    void getAllGames() {
        List<Game> Games = dao.getAllGames();
        assertEquals(3, Games.size());
    }

    @Test
    void insert() {
        Game newGame = new Game();
        newGame.setId(10);
        newGame.setGameURL("https://www.enjpg.com/img/2020/cool-for-boys-4.jpg");
        newGame.setDescription("test will pass");
        dao.insert(newGame);

        int id = dao.insert(newGame);

        assertNotEquals(0,id);
        Game insertedOrder = dao.getById(id);
        assertEquals("https://www.enjpg.com/img/2020/cool-for-boys-4.jpg", insertedOrder.getGameURL());
        assertNotNull(insertedOrder.getDescription());
    }

    @Test
    void delete() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    @Test
    void saveOrUpdate() {
        String description = "test will pass";
        Game gameWillUpdate = dao.getById(2);
        gameWillUpdate.setDescription(description);
        dao.saveOrUpdate(gameWillUpdate);
        Game retrievedBook = dao.getById(2);
        assertEquals(description, retrievedBook.getDescription());
    }
}