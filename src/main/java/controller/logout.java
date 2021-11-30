package controller;

import com.mysql.cj.protocol.x.Notice;
import entity.User;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Resets the session
 *
 * @author Josh Brischke
 */
@WebServlet(
        urlPatterns = {"/logout"}
)

public class logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        String userName = jwt.getClaim("cognito:username").asString();
        String name = jwt.getClaim("name").asString();
        String emailVerified = jwt.getClaim("email_verified").asString();
        logger.debug("msg1" + userName);
        logger.debug("msg1" + name);
        logger.debug("msg1" + emailVerified);
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        List<User> users = userGenericDao.getAll();
        User user = new User(name, emailVerified, userName);
        logger.debug("msg1" + user);
        user.setUserName(userName);
        user.setName(name);
        user.setEmail(emailVerified);
        logger.debug("msg1" + user);
        userGenericDao.insert(user);
        */

        HttpSession session = req.getSession();
        session.invalidate();
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
}