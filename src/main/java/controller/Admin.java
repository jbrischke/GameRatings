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
        if (req.getParameter("submit").equals("viewAll")) {
            req.setAttribute("games", addGameDao.getAllGames());
        }
        if (req.getParameter("submit").equals("deleteID")) {
            Game game = new Game();
            int id = Integer.parseInt(req.getParameter("deleteID"));
            game.setId(id);
           // req.setAttribute("games", addGameDao.delete(game));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(req, resp);
    }
}
