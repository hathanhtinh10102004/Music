package Dao;

import model.User;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{
    private String url = "jdbc:mysql://localhost:3306/WebMusic";
    private String username = "root";
    private String password = "2004";

    private static final String  SELECT_USER = "select * from User where Email = ? and PassWord= ? ";


    public UserDAO(){

    }
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,username,password);
        return connection;
    }


    @Override
    public boolean selectData(String email , String password) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
