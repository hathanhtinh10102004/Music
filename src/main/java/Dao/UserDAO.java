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
    private static final String UPDATE_USERS_SQL = "update User set Name = ?,Email= ?, PhoneNumber =? where Id = ?;";
    private static final String SELECT_USER_UPDATE = "select Id,Name , Email,PhoneNumber from User where Id = ?;";


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

    @Override
    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
        boolean rowUpdate;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setInt(3, user.getPhoneNumber());
        preparedStatement.setInt(4, user.getId());
        rowUpdate = preparedStatement.executeUpdate() >0;
        return rowUpdate;
    }

    @Override
    public List<User> selectUser(int idUser) throws SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_UPDATE);
        preparedStatement.setInt(1, idUser);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int Id = resultSet.getInt("Id");
            String Name = resultSet.getString("Name");
            String Email = resultSet.getString("Email");
            int PhoneNumber = resultSet.getInt("PhoneNumber");
            list.add(new User(Id,Name,Email,PhoneNumber));
        }
        return list;
    }
}
