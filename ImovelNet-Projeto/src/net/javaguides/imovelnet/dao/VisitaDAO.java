package net.javaguides.imovelnet.dao;

import net.javaguides.imovelnet.model.Visita;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VisitaDAO {
    private String jdbcURL = "jdbc:mariadb://db-labsoft.ml:3306/t1g6?useSSL=false";
    private String jdbcUsername = "t1g6";
    private String jdbcPassword = "XFfwPhB";

    private static final String INSERT_VISIT = "INSERT INTO Visita" + "  (idImovel, idUsuario, data, hora) VALUES "
            + " (?, ?, ?, ?);";

    public VisitaDAO() {
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

    public void insertUser(Visita visit) throws SQLException {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VISIT)) {
            preparedStatement.setInt(1, visit.getIdImovel());
            preparedStatement.setInt(2, visit.getIdUsuario());
            preparedStatement.setString(3, visit.getData());
            preparedStatement.setString(4, visit.getHora());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
