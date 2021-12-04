package JBrischke.controller;

import JBrischke.entity.*;
import JBrischke.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * initializes all records
 *
 * @author Josh Brischke
 */
@WebServlet(
        urlPatterns = {"/admininitalize"}
)

public class AdminInitialize extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Game> gameGenericDao = new GenericDao<>(Game.class);
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);

        req.setAttribute("games", gameGenericDao.getAll());
        req.setAttribute("users", userGenericDao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");
        dispatcher.forward(req, resp);
    }
}