package JBrischke.controller;

import JBrischke.entity.*;
import JBrischke.persistence.GenericDao;
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
        urlPatterns = {"/adminFunctions"}
)

public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Game> gameGenericDao = new GenericDao<>(Game.class);
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);

        if (req.getParameter("submit").equals("addGame")) {
            Game game = new Game();
            game.setGameURL(req.getParameter("gameURl"));
            game.setName(req.getParameter("gameName"));
            game.setApiName(req.getParameter("apiName"));
            game.setDescription(req.getParameter("description"));
            req.setAttribute("games", gameGenericDao.insert(game));
            req.setAttribute("games", gameGenericDao.getAll());
            req.setAttribute("users", userGenericDao.getAll());
        }
        if (req.getParameter("submit").equals("deleteRecord")) {
            Game game = new Game();
            int id = Integer.parseInt(req.getParameter("deleteID"));
            game.setId(id);
            req.setAttribute("games", gameGenericDao.delete(game));
            req.setAttribute("games", gameGenericDao.getAll());
            req.setAttribute("users", userGenericDao.getAll());
        }
        if (req.getParameter("submit").equals("update")) {
            Game game = new Game();
            game.setGameURL(req.getParameter("updateURl"));
            game.setName(req.getParameter("updateName"));
            game.setApiName(req.getParameter("apiName"));
            game.setDescription(req.getParameter("updateDescription"));
            game.setId(Integer.parseInt(req.getParameter("updateID")));
            req.setAttribute("games", gameGenericDao.saveOrUpdate(game));
            req.setAttribute("games", gameGenericDao.getAll());
            req.setAttribute("users", userGenericDao.getAll());
        }
        if (req.getParameter("submit").equals("updateUser")) {
            int id = Integer.parseInt(req.getParameter("userID"));
            User userWillUpdate = userGenericDao.getById(id);
            String roleType = req.getParameter("newRole");
            Set<Role> role = userWillUpdate.getRoles();
            for(Role roleTypes : role) {
                roleTypes.setRoleName(roleType);
            }
            userGenericDao.saveOrUpdate(userWillUpdate);
            req.setAttribute("games", gameGenericDao.getAll());
            req.setAttribute("users", userGenericDao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(req, resp);
    }
}
