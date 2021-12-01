package JBrischke.persistence;

import JBrischke.entity.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import JBrischke.persistence.SessionFactoryProvider;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type Admin dao.
 */
public class AdminDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all games.
     *
     * @return the all games
     */
    public List<Game> getAllGames() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Game> query = builder.createQuery(Game.class);
        Root<Game> root = query.from(Game.class);
        List<Game> games = session.createQuery(query).getResultList();
        session.close();
        logger.debug(games);
        return games;
    }

    /**
     * Insert int.
     *
     * @param game the game
     * @return the int
     */
    public int insert(Game game) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(game);
        transaction.commit();
        session.close();
        logger.debug(id);
        return id;
    }

    /**
     * Delete object.
     *
     * @param game the game
     * @return the object
     */
    public Object delete(Game game) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(game);
        transaction.commit();
        session.close();
        logger.debug(game);
        return game;
    }

    /**
     * Save or update object.
     *
     * @param game the game
     * @return the object
     */
    public Object saveOrUpdate(Game game) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(game);
        transaction.commit();
        session.close();
        logger.debug(game);
        return game;
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public Game getById(int id) {
        Session session = sessionFactory.openSession();
        Game game = session.get(Game.class, id);
        session.close();
        logger.debug(game);
        return game;
    }

}
