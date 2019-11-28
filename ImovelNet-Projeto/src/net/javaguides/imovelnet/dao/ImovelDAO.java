package net.javaguides.imovelnet.dao;

import net.javaguides.imovelnet.model.Imovel;
import net.javaguides.imovelnet.model.User;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;


// TODO: Selecionando todos imóveis que nao foram alugados (mesmo os vendidos)

public class ImovelDAO {
    private String jdbcURL = "jdbc:mariadb://db-labsoft.ml:3306/t1g6?useSSL=false";
    private String jdbcUsername = "t1g6";
    private String jdbcPassword = "XFfwPhB";

    private static final String SELECT_HOUSES_FOR_RENT = "select * from Imovel where alugado=0 and paraAlugar=1";
    private static final String SELECT_HOUSES_FOR_SALE = "select * from Imovel where vendido=0 and paraVender=1";
    private static final String SELECT_HOUSE_BY_ID = "select * from Imovel where idImovel =?";

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

    public List<Imovel> selectHousesByType(String tipo) {
        List<Imovel> houses = new ArrayList<>();
        String statement;
        if (tipo == "aluguel"){ statement = SELECT_HOUSES_FOR_RENT; }
        else statement = SELECT_HOUSES_FOR_SALE;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statement);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idImovel");
                float preco;
                if (tipo == "aluguel") { preco = rs.getFloat("PrecoAluguel"); }
                else { preco = rs.getFloat("PrecoVenda"); }
                String descricao = rs.getString("Descricao");
                String endereco = rs.getString("Endereco");
                int idDono = rs.getInt("idDono");
                int paraVender = rs.getInt("paraVender");
                int paraAlugar = rs.getInt("paraAlugar");
                houses.add(new Imovel(id, preco, descricao, endereco, idDono, tipo, paraVender, paraAlugar));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return houses;
    }

    public Imovel selectImovelById(int id) {
        Imovel house = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOUSE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String endereco = rs.getString("Endereco");
                String descricao = rs.getString("Descricao");
                float precoAluguel = rs.getFloat("precoAluguel");
                float precoVenda = rs.getFloat("precoVenda");
                int idDono = rs.getInt("idDono");
                int paraVender = rs.getInt("paraVender");
                int paraAlugar = rs.getInt("paraAlugar");
                house = new Imovel(id, endereco, descricao, precoAluguel, precoVenda, idDono, paraVender, paraAlugar);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return house;
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
