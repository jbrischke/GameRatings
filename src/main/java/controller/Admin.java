package controller;

import entity.Game;
import persistence.AdminDao;
import persistence.GenericDao;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;

import java.io.IOException;

/**
 * The type Admin.
 */
@WebServlet(
        urlPatterns = {"/adminFunctions"}
)

public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminDao adminDao = new AdminDao();

        if (req.getParameter("submit").equals("addGame")) {
            Game game = new Game();
            game.setGameURL(req.getParameter("gameURl"));
            game.setName(req.getParameter("gameName"));
            game.setDescription(req.getParameter("description"));
            req.setAttribute("games", adminDao.insert(game));
            req.setAttribute("games", adminDao.getAllGames());
        }
        if (req.getParameter("submit").equals("deleteRecord")) {
            Game game = new Game();
            int id = Integer.parseInt(req.getParameter("deleteID"));
            game.setId(id);
            req.setAttribute("games", adminDao.delete(game));
            req.setAttribute("games", adminDao.getAllGames());
        }
        if (req.getParameter("submit").equals("update")) {
            Game game = new Game();
            game.setGameURL(req.getParameter("updateURl"));
            game.setName(req.getParameter("updateName"));
            game.setDescription(req.getParameter("updateDescription"));
            game.setId(Integer.parseInt(req.getParameter("updateID")));
            req.setAttribute("games", adminDao.saveOrUpdate(game));
            req.setAttribute("games", adminDao.getAllGames());

        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(req, resp);
    }
}
