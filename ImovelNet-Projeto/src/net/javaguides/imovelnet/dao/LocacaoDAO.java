package net.javaguides.imovelnet.dao;

import net.javaguides.imovelnet.model.Locacao;
import net.javaguides.imovelnet.model.Usuario;

import java.sql.*;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import net.javaguides.imovelnet.model.Imovel;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class LocacaoDAO {
    private String jdbcURL = "jdbc:mariadb://db-labsoft.ml:3306/t1g6?useSSL=false";
    private String jdbcUsername = "t1g6";
    private String jdbcPassword = "XFfwPhB";
    private UsuarioDAO usuarioDAO;

    private static final String INSERT_RENT = "INSERT INTO Locacao" + "  (idUsuario, dataInicio, idImovel, dataFinal, precoLocacao, parcelasRestantes) VALUES "
            + " (?, ?, ?, ?, ?, ?);";
    private static final String CHANGE_HOUSE_TO_RENTED = "UPDATE Imovel set Alugado = 1 where idImovel = ?";
    private static final String CHANGE_HOUSE_TO_NOT_RENTED = "UPDATE Imovel set Alugado = 0 where idImovel = ?";

    private static final String SELECT_ALL_RENTED_HOUSES = "SELECT * FROM Locacao";
    private static final String GET_USER_BY_ID = "select * from Usuario where idUsuario=?";
    private static final String SELECT_RENTED_BY_USER_ID = "SELECT * FROM Locacao WHERE idUsuario = ?";
    private static final String PAY_RENT = "UPDATE Locacao SET ParcelasRestantes = ParcelasRestantes - 1 WHERE idLocacao = ?";
    private static final String SELECT_RENT_BY_ID = "SELECT * FROM Locacao where idLocacao = ?";

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
                Date dataFinal = rs.getDate("DataFinal");
                Date dataInicio = rs.getDate("DataInicio");
                int idImovel = rs.getInt("idImovel");
                Float precoLocacao = rs.getFloat("PrecoLocacao");
                Usuario user = this.getUsuarioById(idUsuario);
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
            preparedStatement.setDate(2, rent.getDataInicio());
            preparedStatement.setInt(3, rent.getIdImovel());
            preparedStatement.setDate(4, rent.getDataFinal());
            preparedStatement.setFloat(5, rent.getPrecoLocacao());
            LocalDate dataInicio = rent.getDataInicio().toLocalDate();
            LocalDate dataFinal = rent.getDataFinal().toLocalDate();
            long months = ChronoUnit.MONTHS.between(dataInicio, dataFinal);
            preparedStatement.setLong(6, months);
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement1 = connection.prepareStatement(CHANGE_HOUSE_TO_RENTED);
            preparedStatement1.setInt(1, rent.getIdImovel());
            System.out.println(preparedStatement1);
            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario getUsuarioById(int id) {
        String statement = GET_USER_BY_ID;
        Usuario user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statement);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("Nome");
                String role = rs.getString("Role");
                String CPF = rs.getString("CPF");
                String email = rs.getString("Email");
                user = new Usuario(id, nome, role, CPF, email);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    public List<Locacao> getRentsByUserId(int userId) {
        List<Locacao> rents = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENTED_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int idLocacao = rs.getInt("idLocacao");
                int idUsuario = rs.getInt("idUsuario");
                Date dataFinal = rs.getDate("DataFinal");
                Date dataInicio = rs.getDate("DataInicio");
                int idImovel = rs.getInt("idImovel");
                Float precoLocacao = rs.getFloat("PrecoLocacao");
                int parcelasRestantes = rs.getInt("ParcelasRestantes");
                Usuario user = this.getUsuarioById(idUsuario);
                ImovelDAO imovelDAO = new ImovelDAO();
                Imovel house = imovelDAO.selectImovelById(idImovel);
                Locacao rent = new Locacao(idLocacao, idUsuario, dataInicio, idImovel, dataFinal, precoLocacao, user, parcelasRestantes);
                rent.setHouse(house);
                rents.add(rent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rents;
    }

    public void pay_rent(int idLocacao) {
        String statement = PAY_RENT;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statement);) {
            preparedStatement.setInt(1, idLocacao);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            String selectStatement = SELECT_RENT_BY_ID;
            PreparedStatement preparedStatement1 = connection.prepareStatement(selectStatement);
            preparedStatement1.setInt(1, idLocacao);
            ResultSet rs = preparedStatement1.executeQuery();
            rs.next();
            int parcelas = rs.getInt("ParcelasRestantes");
            if (parcelas == 0) {
                String statement1 = CHANGE_HOUSE_TO_NOT_RENTED;
                PreparedStatement preparedStatement2 = connection.prepareStatement(statement1);
                preparedStatement2.setInt(1, rs.getInt("idImovel"));
                preparedStatement2.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }




}
