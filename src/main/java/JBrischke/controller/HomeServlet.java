package JBrischke.controller;

import JBrischke.entity.*;
import JBrischke.persistence.GenericDao;
import JBrischke.persistence.PriceDao;
import com.mchange.v2.log.MLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * initializes all records
 *
 * @author Josh Brischke
 */
@WebServlet(
        urlPatterns = {"/GoingHome"}
)

public class HomeServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Game> gameGenericDao = new GenericDao<>(Game.class);

        PriceDao priceDao = new PriceDao();

        req.setAttribute("games", gameGenericDao.getAll());
        req.setAttribute("prices", priceDao);

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
}