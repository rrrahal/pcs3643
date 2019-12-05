package net.javaguides.imovelnet.dao;

import net.javaguides.imovelnet.model.Usuario;

import java.sql.*;


public class UsuarioDAO {
    private String jdbcURL = "jdbc:mariadb://db-labsoft.ml:3306/t1g6?useSSL=false";
    private String jdbcUsername = "t1g6";
    private String jdbcPassword = "XFfwPhB";

    private static final String CHECK_LOGIN = "select * from Usuario where email =? and senha=?";

    public UsuarioDAO() {
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

    public Usuario hangleLogin(String email, String senha) {
        String statement = CHECK_LOGIN;
        Usuario user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statement);) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("Nome");
                String role = rs.getString("Role");
                int id = rs.getInt("IdUsuario");
                user = new Usuario(id, nome, role);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }
}
