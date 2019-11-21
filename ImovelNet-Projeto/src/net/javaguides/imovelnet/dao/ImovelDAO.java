package net.javaguides.imovelnet.dao;

import net.javaguides.imovelnet.model.Imovel;
import net.javaguides.imovelnet.model.User;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ImovelDAO {
    private String jdbcURL = "jdbc:mariadb://db-labsoft.ml:3306/t1g6?useSSL=false";
    private String jdbcUsername = "t1g6";
    private String jdbcPassword = "XFfwPhB";

    private static final String SELECT_HOUSES_FOR_RENT = "select * from Imovel where alugado=0";

    public ImovelDAO() {
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

    public List<Imovel> selectHousesForRent() {
        List<Imovel> houses = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOUSES_FOR_RENT);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idImovel");
                float preçoAluguel = rs.getFloat("PreçoVenda");
                String descricao = rs.getString("Descrição");
                String endereco = rs.getString("Endereço");
                int idDono = rs.getInt("idDono");
                houses.add(new Imovel(id, preçoAluguel, descricao, endereco, idDono));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return houses;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
