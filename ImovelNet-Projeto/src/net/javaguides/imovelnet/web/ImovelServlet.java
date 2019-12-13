package net.javaguides.imovelnet.web;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.imovelnet.dao.*;
import net.javaguides.imovelnet.model.*;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/")
public class ImovelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ImovelDAO imovelDAO;
    private UsuarioDAO usuarioDAO;
    private VisitaDAO visitaDAO;
    private LocacaoDAO locacaoDAO;
    private VendaDAO vendaDAO;

    public void init() {
        imovelDAO = new ImovelDAO();
        usuarioDAO = new UsuarioDAO();
        visitaDAO = new VisitaDAO();
        locacaoDAO = new LocacaoDAO();
        vendaDAO = new VendaDAO();
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
                case "/sale":
                    listHousesToSale(request, response);
                    break;
                case "/house":
                    showHouse(request, response);
                    break;
                case "/login":
                    login(request, response);
                    break;
                case "/handle_login":
                    handle_login(request, response);
                    break;
                case "/schedule_visit":
                    schedule_visit(request, response);
                    break;
                case "/handle_visit":
                    handle_visit(request, response);
                    break;
                case "/make_rent":
                    make_rent(request, response);
                    break;
                case "/handle_rent":
                    handle_rent(request, response);
                    break;
                case "/make_sale" :
                    make_sale(request, response);
                    break;
                case "/handle_sale":
                    handle_sale(request, response);
                    break;
                case "/reports":
                    make_reports(request, response);
                    break;
                case "/generate_rent_reports":
                    make_rent_reports(request, response);
                    break;
                case "/my_rents":
                    show_my_rents(request, response);
                    break;
                case "/pay_rent":
                    pay_rent(request, response);
                    break;
                case "/renew_rent":
                    renew_rent(request,response);
                    break;
                case "/my_sales":
                    show_my_sales(request, response);
                    break;
                case "/pay_sale":
                    pay_sale(request, response);
                    break;
                case "/generate_sale_reports" :
                    make_sale_reports(request, response);
                    break;
                default:
                    login(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    // Listar casa para alugar
    private void listHousesToRent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Imovel> houses = imovelDAO.selectHousesByType("aluguel");
        request.setAttribute("houses", houses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("forRent.jsp");
        dispatcher.forward(request, response);
    }

    private void listHousesToSale(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Imovel> houses = imovelDAO.selectHousesByType("venda");
        request.setAttribute("houses", houses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("forSale.jsp");
        dispatcher.forward(request, response);
    }

    private void showHouse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Imovel house = imovelDAO.selectImovelById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("house-page.jsp");
        request.setAttribute("house", house);
        dispatcher.forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    private void handle_login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            Usuario user = usuarioDAO.hangleLogin(email, senha);
            if (user != null) {
                HttpSession session=request.getSession();
                session.setAttribute("idUsuario", user.getIdUsuario());
                session.setAttribute("role", user.getRole());
                response.sendRedirect("index.jsp");
            }
    }

    private void schedule_visit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("imovelId"));
        Imovel house = imovelDAO.selectImovelById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("schedule_visit.jsp");
        request.setAttribute("house", house);
        dispatcher.forward(request, response);
    }

    private void handle_visit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idImovel = Integer.parseInt(request.getParameter("idImovel"));
        String data = request.getParameter("data");
        String hora = request.getParameter("hora");
        HttpSession session = request.getSession();
        if (session.getAttribute("idUsuario") != null) {
            int idUsuario = (Integer) session.getAttribute("idUsuario");
            Visita visit = new Visita(idUsuario, idImovel, data, hora);
            visitaDAO.insertUser(visit);
            RequestDispatcher dispatcher = request.getRequestDispatcher("visit_scheduled.jsp");
            dispatcher.forward(request, response);
        }
        else {
            System.out.println("O usuario não está logado!");
        }

    }

    private void handle_rent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idImovel = Integer.parseInt(request.getParameter("idImovel"));
        String sdataInicio = request.getParameter("dataInicio");
        String sdataFinal = request.getParameter("dataFinal");
        Date dataInicio = Date.valueOf(sdataInicio);
        Date dataFinal = Date.valueOf(sdataFinal);
        float precoLocacao = Float.parseFloat(request.getParameter("precoLocacao"));
        HttpSession session = request.getSession();
        if (session.getAttribute("idUsuario") != null) {
            int idUsuario = (Integer) session.getAttribute("idUsuario");
            Locacao rent = new Locacao(idUsuario, dataInicio, idImovel, dataFinal, precoLocacao);
            locacaoDAO.insertRent(rent);
            RequestDispatcher dispatcher = request.getRequestDispatcher("rent_done.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void make_rent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idImovel = Integer.parseInt(request.getParameter("idImovel"));
        Imovel house = imovelDAO.selectImovelById(idImovel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("make_rent.jsp");
        request.setAttribute("house", house);
        dispatcher.forward(request, response);
    }

    private void make_sale(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idImovel = Integer.parseInt(request.getParameter("idImovel"));
        Imovel house = imovelDAO.selectImovelById(idImovel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("make_sale.jsp");
        request.setAttribute("house", house);
        dispatcher.forward(request, response);
    }

    private void handle_sale(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idImovel = Integer.parseInt(request.getParameter("idImovel"));
        String dataInicio = request.getParameter("dataInicio");
        String dataFinal = request.getParameter("dataFim");
        float valorEntrada = Float.parseFloat(request.getParameter("precoEntrada"));
        int nParcelas = Integer.parseInt(request.getParameter("nParcelas"));
        float valorParcelas = Float.parseFloat(request.getParameter("valorParcelas"));
        HttpSession session = request.getSession();
        if (session.getAttribute("idUsuario") != null) {
            int idUsuario = (Integer) session.getAttribute("idUsuario");
            Venda sale = new Venda(Date.valueOf(dataInicio), Date.valueOf(dataFinal), valorEntrada, nParcelas, valorParcelas, idUsuario, idImovel);
            vendaDAO.insertSale(sale);
            RequestDispatcher dispatcher = request.getRequestDispatcher("sale_done.jsp");
            dispatcher.forward(request, response);
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void make_reports(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("role"));
        String role = (String) session.getAttribute("role");
        if (role.equalsIgnoreCase("ADMIN")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("generate_reports.jsp");
            dispatcher.forward(request, response);
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void make_rent_reports(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Locacao> valid_rents = new ArrayList<>();
        String sdataInicio = request.getParameter("dataInicio");
        Date dataInicio = Date.valueOf(sdataInicio);
        List<Locacao> rents = locacaoDAO.getRentedHouses();
        for (Locacao rent : rents) {
            if(dataInicio.before(rent.getDataInicio())){
                valid_rents.add(rent);
            }
        }
        request.setAttribute("rents", valid_rents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("rent_reports.jsp");
        dispatcher.forward(request, response);
    }

    private void show_my_rents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("idUsuario") != null) {
            int idUsuario = (Integer) session.getAttribute("idUsuario");
            List<Locacao> rents = locacaoDAO.getRentsByUserId(idUsuario);
            request.setAttribute("rents", rents);
            RequestDispatcher dispatcher = request.getRequestDispatcher("my_rents.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void pay_rent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idLocacao = Integer.parseInt(request.getParameter("idLocacao"));
        locacaoDAO.pay_rent(idLocacao);
        this.show_my_rents(request, response);
    }

    private void renew_rent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idLocacao = Integer.parseInt(request.getParameter("idLocacao"));
        String sdataInicio = request.getParameter("dataInicio");
        String sdataFinal = request.getParameter("dataFim");
        Date dataInicio = Date.valueOf(sdataInicio);
        Date dataFinal = Date.valueOf(sdataFinal);
        Locacao oldRent = locacaoDAO.getRentById(idLocacao);
        Locacao rent = new Locacao(oldRent.getIdUsuario(), dataInicio, oldRent.getIdImovel(), dataFinal, oldRent.getPrecoLocacao());
        locacaoDAO.insertRent(rent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("rent_done.jsp");
        dispatcher.forward(request, response);
    }

    private void show_my_sales(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("idUsuario") != null) {
            int idUsuario = (Integer) session.getAttribute("idUsuario");
            List<Venda> sales = vendaDAO.getSalesByUserId(idUsuario);
            request.setAttribute("sales", sales);
            RequestDispatcher dispatcher = request.getRequestDispatcher("my_sales.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void pay_sale(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idVenda = Integer.parseInt(request.getParameter("idVenda"));
        vendaDAO.pay_sale(idVenda);
        this.show_my_sales(request, response);
    }

    private void make_sale_reports(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Venda> valid_sales = new ArrayList<>();
        String sdataInicio = request.getParameter("dataInicio");
        Date dataInicio = Date.valueOf(sdataInicio);
        List<Venda> sales = vendaDAO.getSales();
        for (Venda sale : sales) {
            Date dataInicioSale = sale.getDataInicio();
            if(dataInicio.before(dataInicioSale)){
                valid_sales.add(sale);
            }
        }
        request.setAttribute("sales", valid_sales);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sale_reports.jsp");
        dispatcher.forward(request, response);
    }
}
