package ru.alexking.servlets;

import org.slf4j.Logger;
import ru.alexking.models.PetType;
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
public class PetTypeServlet extends HttpServlet {
    private static final Logger log = getLogger(PetTypeServlet.class);
    private final PetTypeStorage types = PetTypeStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("types", this.types.getAll());
        req.getRequestDispatcher("/WEB-INF/views/pets/types.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PetType type = new PetType();
        type.setName(req.getParameter("name"));
        this.types.add(type);
        resp.sendRedirect(String.format("%s/pets/types.do", req.getContextPath()));
    }
}
