package ru.alexking.servlets;

import org.slf4j.Logger;
import ru.alexking.models.User;
import ru.alexking.storages.MessageStorage;
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
public class ClientServlet extends HttpServlet {
    private static final Logger log = getLogger(ClientServlet.class);
    private final UserStorage users = UserStorage.getInstance();
    private final MessageStorage messages = MessageStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        req.setAttribute("messages", this.messages.findByOwner(user.getId()));
        req.getRequestDispatcher("/WEB-INF/views/clients/client.jsp").forward(req, resp);
    }
}
