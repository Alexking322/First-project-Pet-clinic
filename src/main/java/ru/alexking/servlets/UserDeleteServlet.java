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
public class UserDeleteServlet extends HttpServlet {
    private static final Logger log = getLogger(UserDeleteServlet.class);
    private final RoleStorage roles = RoleStorage.getInstance();
    private final UserStorage users = UserStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.users.delete(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect(String.format("%s/users.do", req.getContextPath()));
    }
}
