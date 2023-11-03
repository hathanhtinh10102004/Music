package Dao;

import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class UserDAO implements IUserDAO {
    private String ConnectUrl = "jdbc:mysql://localhost:3306/WebMusic";
    private String userName = "root";
    private String passWord = "1";
    private static String ADD_USER = "INSERT INTO User (Name,Email,PhoneNumber,PassWord) values (?,?,?,?)";
    private static String UPDATE_PASSWORD_USER = "UPDATE User SET PassWord = ? WHERE Id = ?";
    private static String SELECT_PASSWORD_BY_ID = "SELECT Id,PassWord FROM User WHERE Id = ? AND PassWord = ?";


    public Connection connection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(ConnectUrl,userName,passWord);
        return connection;
    }

    public void addUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER);
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getEmail());
        preparedStatement.setInt(3,user.getPhoneNumber());
        preparedStatement.setString(4,user.getPassWord());
        preparedStatement.executeUpdate();
    }

    public boolean findPasswordById(int id, String passWord) throws SQLException, ClassNotFoundException {
        Connection connection = connection();
        User user = null;
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PASSWORD_BY_ID);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,passWord);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public void editPassWordUser(int id, String password) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD_USER);
        preparedStatement.setString(1,password);
        preparedStatement.setInt(2,id);
        preparedStatement.executeUpdate();
    }

}
