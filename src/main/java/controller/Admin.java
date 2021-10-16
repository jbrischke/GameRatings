package controller;

import entity.Game;
import persistence.AddGameDao;
import persistence.UserDao;

import persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.validation.constraints.Null;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/adminFunctions"}
)

public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AddGameDao addGameDao = new AddGameDao();
        if (req.getParameter("submit").equals("addGame")) {
            Game game = new Game();
            game.setGameURL(req.getParameter("gameURl"));
            game.setDescription(req.getParameter("description"));
            req.setAttribute("games", addGameDao.insert(game));
            req.setAttribute("games", addGameDao.getAllGames());
        }
        if (req.getParameter("submit").equals("deleteRecord")) {
            Game game = new Game();
            int id = Integer.parseInt(req.getParameter("deleteID"));
            game.setId(id);
            req.setAttribute("games", addGameDao.delete(game));
            req.setAttribute("games", addGameDao.getAllGames());
        }
        if (req.getParameter("submit").equals("update")) {
            Game game = new Game();
            game.setGameURL(req.getParameter("updateURl"));
            game.setDescription(req.getParameter("updateDescription"));
            game.setId(Integer.parseInt(req.getParameter("updateID")));
            req.setAttribute("games", addGameDao.saveOrUpdate(game));
            req.setAttribute("games", addGameDao.getAllGames());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(req, resp);
    }
}
