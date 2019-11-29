package net.javaguides.imovelnet.dao;

import net.javaguides.imovelnet.model.Locacao;
import net.javaguides.imovelnet.model.Usuario;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class LocacaoDAO {
    private String jdbcURL = "jdbc:mariadb://db-labsoft.ml:3306/t1g6?useSSL=false";
    private String jdbcUsername = "t1g6";
    private String jdbcPassword = "XFfwPhB";
    private UsuarioDAO usuarioDAO;

    private static final String INSERT_RENT = "INSERT INTO Locacao" + "  (idUsuario, dataInicio, idImovel, dataFinal, precoLocacao) VALUES "
            + " (?, ?, ?, ?, ?);";
    private static final String CHANGE_HOUSE_TO_RENTED = "UPDATE Imovel set Alugado = 1 where idImovel = ?";

    private static final String SELECT_ALL_RENTED_HOUSES = "SELECT * FROM Locacao";

    public void init() {
        usuarioDAO = new UsuarioDAO();
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

    public List<Locacao> getRentedHouses() {
        List<Locacao> rents = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENTED_HOUSES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int idLocacao = rs.getInt("idLocacao");
                int idUsuario = rs.getInt("idUsuario");
                String dataFinal = rs.getString("DataFinal");
                String dataInicio = rs.getString("DataInicio");
                int idImovel = rs.getInt("idImovel");
                Float precoLocacao = rs.getFloat("PrecoLocacao");
                Usuario user = usuarioDAO.getUsuarioById(idUsuario);
                Locacao rent = new Locacao(idLocacao, idUsuario, dataInicio, idImovel, dataFinal, precoLocacao, user);
                rents.add(rent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rents;
    }

    public void insertRent(Locacao rent) throws SQLException {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RENT)) {
            preparedStatement.setInt(1, rent.getIdUsuario());
            preparedStatement.setString(2, rent.getDataInicio());
            preparedStatement.setInt(3, rent.getIdImovel());
            preparedStatement.setString(4, rent.getDataFinal());
            preparedStatement.setFloat(5, rent.getPrecoLocacao());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement1 = connection.prepareStatement(CHANGE_HOUSE_TO_RENTED);
            preparedStatement1.setInt(1, rent.getIdImovel());
            System.out.println(preparedStatement1);
            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
