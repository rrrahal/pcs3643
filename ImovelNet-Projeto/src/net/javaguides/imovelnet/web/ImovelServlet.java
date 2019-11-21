package net.javaguides.imovelnet.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.imovelnet.dao.ImovelDAO;
import net.javaguides.imovelnet.model.Imovel;
import net.javaguides.imovelnet.model.User;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/")
public class ImovelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ImovelDAO imovelDAO;

    public void init() {
        imovelDAO = new ImovelDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/rent":
                    listHousesToRent(request, response);
                    break;
                default:
                    listHousesToRent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    // Listar casa para alugar
    private void listHousesToRent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Imovel> houses = imovelDAO.selectHousesForRent();
        request.setAttribute("houses", houses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("forRent.jsp");
        dispatcher.forward(request, response);
    }
}
