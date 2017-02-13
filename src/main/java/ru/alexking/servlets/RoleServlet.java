package ru.alexking.servlets;

import org.slf4j.Logger;
import ru.alexking.storages.RoleStorage;

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
public class RoleServlet extends HttpServlet {
    private static final Logger log = getLogger(RoleServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", RoleStorage.getInstance().getAll());
        req.getRequestDispatcher("/WEB-INF/views/roles/roles.jsp").forward(req, resp);
    }
}
