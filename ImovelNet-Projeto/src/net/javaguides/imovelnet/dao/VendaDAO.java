package net.javaguides.imovelnet.dao;

import net.javaguides.imovelnet.model.Imovel;
import net.javaguides.imovelnet.model.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    private String jdbcURL = "jdbc:mariadb://db-labsoft.ml:3306/t1g6?useSSL=false";
    private String jdbcUsername = "t1g6";
    private String jdbcPassword = "XFfwPhB";

    private static final String INSERT_SALE = "INSERT INTO Venda" + "  (DataInicio, DataFim, ValorParcelas, NParcelas, ValorEntrada, idUsuario, idImovel) VALUES "
            + " (?, ?, ?, ?, ?, ?, ?);";
    private static final String CHANGE_HOUSE_TO_RENT = "UPDATE Imovel set Vendido = 1 where idImovel = ?";

    private static final String SELECT_SALE_BY_USER = "SELECT * FROM Venda where idUsuario = ?";

    private static final String PAY_SALE = "UPDATE Venda SET ParcelasPagas = ParcelasPagas + 1 WHERE idVenda = ?";

    private static final String SELECT_SALE_BY_ID = "SELECT * FROM VENDA WHERE idVenda = ?";

    private static final String CHANGE_SALE_TO_FINISH = "UPDATE Venda Set Finalizada = 1 where idVenda = ?";

    private static final String GET_SALES = "SELECT * FROM Venda";

    public VendaDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertSale(Venda sale) throws SQLException {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SALE)) {
            preparedStatement.setString(1, sale.getDataInicio().toString());
            preparedStatement.setString(2, sale.getDataFim().toString());
            preparedStatement.setFloat(3, sale.getValorParcelas());
            preparedStatement.setInt(4, sale.getnParcelas());
            preparedStatement.setFloat(5, sale.getValorEntrada());
            preparedStatement.setInt(6, sale.getIdUsuario());
            preparedStatement.setInt(7, sale.getIdImovel());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement2 = connection.prepareStatement(CHANGE_HOUSE_TO_RENT);
            preparedStatement2.setInt(1, sale.getIdImovel());
            preparedStatement2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Venda> getSalesByUserId(int idUsuario)throws SQLException {
        // try-with-resource statement will auto close the connection.
        List<Venda> sales = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SALE_BY_USER)) {
            preparedStatement.setInt(1, idUsuario);
            System.out.print(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int idVenda = rs.getInt("idVenda");
                float valorParcelas = rs.getFloat("ValorParcelas");
                int nParcelas = rs.getInt("NParcelas");
                float valorEntrada = rs.getFloat("ValorEntrada");
                Date dataInicio = rs.getDate("DataInicio");
                Date dataFim = rs.getDate("DataFim");
                int idImovel = rs.getInt("idImovel");
                int parcelasPagas = rs.getInt("ParcelasPagas");
                ImovelDAO imovelDAO = new ImovelDAO();
                Imovel house = imovelDAO.selectImovelById(idImovel);
                Venda sale = new Venda(idVenda,dataInicio, dataFim, valorEntrada, nParcelas, valorParcelas, idUsuario, idImovel, house, parcelasPagas);
                sales.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }

    public void pay_sale(int idVenda) {
        String statement = PAY_SALE;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statement);) {
            preparedStatement.setInt(1, idVenda);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            String selectStatement = SELECT_SALE_BY_ID;
            PreparedStatement preparedStatement1 = connection.prepareStatement(selectStatement);
            preparedStatement1.setInt(1, idVenda);
            ResultSet rs = preparedStatement1.executeQuery();
            rs.next();
            int parcelas = rs.getInt("nParcelas");
            int parcelasPagas = rs.getInt("ParcelasPagas");
            if (parcelas == parcelasPagas ) {
                String statement1 = CHANGE_SALE_TO_FINISH;
                PreparedStatement preparedStatement2 = connection.prepareStatement(statement1);
                preparedStatement2.setInt(1, idVenda);
                preparedStatement2.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Venda> getSales() {
        String statement = GET_SALES;
        List<Venda> sales = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statement);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int idVenda = rs.getInt("idVenda");
                float valorParcelas = rs.getFloat("ValorParcelas");
                int nParcelas = rs.getInt("nParcelas");
                float valorEntrada = rs.getFloat("ValorEntrada");
                Date dataInicio = rs.getDate("DataInicio");
                Date dataFim = rs.getDate("DataFim");
                int idImovel = rs.getInt("idImovel");
                int idUsuario = rs.getInt("idUsuario");
                int parcelasPagas = rs.getInt("ParcelasPagas");
                ImovelDAO imovelDAO = new ImovelDAO();
                Imovel house = imovelDAO.selectImovelById(idImovel);
                Venda sale = new Venda(idVenda, dataInicio, dataFim, valorEntrada, nParcelas, valorParcelas, idUsuario, idImovel, house, parcelasPagas);
                sales.add(sale);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sales;
    }

}
