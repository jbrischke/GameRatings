package JBrischke.controller;

import JBrischke.entity.*;
import JBrischke.persistence.GenericDao;
import JBrischke.persistence.PriceDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        urlPatterns = {"/Reports"}
)

public class Report extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Game> gameGenericDao = new GenericDao<>(Game.class);
        Game game = new Game();

        int id = Integer.parseInt(req.getParameter("gameID"));
        //logger.debug("id being passed" + id);

        String gameName = req.getParameter("gameName");
        String name = "minecraft";

        //logger.debug("reports passed game name " + gameName);

        PriceDao dao = new PriceDao();
        //req.setAttribute("price", dao.getPrice(name));
        //logger.debug("api returned information" + dao.getPrice(name));

        game.setId(id);
        req.setAttribute("games", gameGenericDao.getById(game.getId()));
        //logger.debug("report info" + gameGenericDao.getById(game.getId()));

        RequestDispatcher dispatcher = req.getRequestDispatcher("report.jsp");
        dispatcher.forward(req, resp);
    }
}