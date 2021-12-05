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
import java.util.*;

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

        Logger logger = LogManager.getLogger(this.getClass());

        GenericDao<Game> gameGenericDao = new GenericDao<>(Game.class);
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        GenericDao<Role> roleGenericDao = new GenericDao<>(Role.class);

        List<User> users = userGenericDao.getAll();

        for(User user : users) {
            List<Role> roles = roleGenericDao.getByPropertyEqual("userName", user.getUserName());
            for(Role roleItem : roles) {
                user.addRole(roleItem);
                logger.debug("admin load output inside role loop" + roleItem.getRole_id());
            }
            logger.debug("admin load output inside loop" + roles);
        }

        logger.debug("admin load output" + users);

        req.setAttribute("games", gameGenericDao.getAll());
        req.setAttribute("users", users);

        RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");
        dispatcher.forward(req, resp);
    }
}