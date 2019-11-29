package net.javaguides.imovelnet.dao;

import net.javaguides.imovelnet.model.Venda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendaDAO {
    private String jdbcURL = "jdbc:mariadb://db-labsoft.ml:3306/t1g6?useSSL=false";
    private String jdbcUsername = "t1g6";
    private String jdbcPassword = "XFfwPhB";

    private static final String INSERT_SALE = "INSERT INTO Venda" + "  (DataInicio, DataFim, ValorParcelas, NParcelas, ValorEntrada, idUsuario, idImovel) VALUES "
            + " (?, ?, ?, ?, ?, ?, ?);";
    private static final String CHANGE_HOUSE_TO_RENT = "UPDATE Imovel set Vendido = 1 where idImovel = ?";

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
            preparedStatement.setString(1, sale.getDataInicio());
            preparedStatement.setString(2, sale.getDataFim());
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
}
