package ru.alexking.servlets;

import org.slf4j.Logger;
import ru.alexking.storages.PetTypeStorage;

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
public class PetServlet extends HttpServlet {
    private static final Logger log = getLogger(PetServlet.class);
    private final PetTypeStorage types = PetTypeStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("types", this.types.getAll());
        req.setAttribute("user_id", req.getParameter("id"));
        req.getRequestDispatcher("/WEB-INF/views/pets/add.jsp").forward(req, resp);
    }
}
