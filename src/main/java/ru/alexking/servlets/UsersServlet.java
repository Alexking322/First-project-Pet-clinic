package ru.alexking.servlets;

import org.slf4j.Logger;
import ru.alexking.storages.RoleStorage;
import ru.alexking.storages.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author alexking
 * @since 30.01.2017
 */
public class UsersServlet extends HttpServlet {
    private static final Logger log = getLogger(UsersServlet.class);
    private final RoleStorage roles = RoleStorage.getInstance();
    private final UserStorage users = UserStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", this.users.getAll());
        req.getRequestDispatcher("/WEB-INF/views/users/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
