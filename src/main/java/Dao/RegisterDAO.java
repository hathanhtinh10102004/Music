package Dao;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO implements IRegister {
    private String jdbcURL = "jdbc:mysql://localhost:3306/WebMusic";
    private  String jdbcUsername = "root";
    private  String jdbcPassword ="2004";

    public RegisterDAO(){}

    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }
    private static final String INSERT_User_SQL = "INSERT INTO User( Name, Email,PhoneNumber,PassWord) VALUE (?,?,?,?)";

    @Override
    public void insertMusic(User user) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_User_SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2,user.getEmail());
        preparedStatement.setInt(3,user.getPhoneNumber());
        preparedStatement.setString(4,user.getPassWord());
        preparedStatement.executeUpdate();

    }
}
