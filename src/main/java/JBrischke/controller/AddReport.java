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
import java.util.Set;

@WebServlet(
        urlPatterns = {"/AddReport"}
)

public class AddReport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Game> gameGenericDao = new GenericDao<>(Game.class);
        GenericDao<Report> reportGenericDao = new GenericDao<>(Report.class);
        Logger logger = LogManager.getLogger(this.getClass());

        if (req.getParameter("submit").equals("Report")) {
            Game game = new Game();
            int id = Integer.parseInt(req.getParameter("inReportID"));
            game.setId(id);

            String reportDescription = req.getParameter("addReportOpinion");
            int hoursPlayed = Integer.parseInt(req.getParameter("addReportHoursPlayed"));

            Report report = new Report(reportDescription, hoursPlayed);
            game.addReport(report);
            reportGenericDao.insert(report);
            /*
            String gameName = req.getParameter("gameName");
            logger.debug("inside the add report part" + gameName);
            PriceDao priceDao = new PriceDao();
            req.setAttribute("price", priceDao.getPrice(gameName));
            logger.debug("this is the price of minecraft " + priceDao.getPrice(gameName));
            */
        }

        req.setAttribute("games", gameGenericDao.getById(Integer.parseInt(req.getParameter("inReportID"))));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/report.jsp");
        dispatcher.forward(req, resp);
    }
}
