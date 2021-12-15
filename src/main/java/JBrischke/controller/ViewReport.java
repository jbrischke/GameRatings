package JBrischke.controller;

import JBrischke.entity.*;
import JBrischke.persistence.GenericDao;
import JBrischke.persistence.PriceDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;

import java.io.IOException;

/**
 * The type View report.
 */
@WebServlet(
        urlPatterns = {"/Reports"}
)

public class ViewReport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Game> gameGenericDao = new GenericDao<>(Game.class);
        Logger logger = LogManager.getLogger(this.getClass());

        //returns a single game object passed in from the page
        req.setAttribute("games", gameGenericDao.getById(Integer.parseInt(req.getParameter("gameID"))));

        /*
        // creates a price object and returns an entity of the price api
        String gameName = req.getParameter("gameName");
        PriceDao priceDao = new PriceDao();
        req.setAttribute("price", priceDao.getPrice(gameName));
        logger.debug("this is the price of minecraft " + priceDao.getPrice(gameName));
        */

        RequestDispatcher dispatcher = req.getRequestDispatcher("/report.jsp");
        dispatcher.forward(req, resp);
    }

}
