package Dao;

import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String ConnectUrl = "jdbc:mysql://localhost:3306/WebMusic";
    private String userName = "root";
    private String passWord = "2004";
    private static final String ADD_USER = "INSERT INTO User (Name,Email,PhoneNumber,PassWord) values (?,?,?,?)";
    private static final String UPDATE_PASSWORD_USER = "UPDATE User SET PassWord = ? WHERE Id = ?";
    private static final String SELECT_PASSWORD_BY_ID = "SELECT Id,PassWord FROM User WHERE Id = ? AND PassWord = ?";

    private static final String  SELECT_USER = "select * from User where Email = ? and PassWord= ? ";
    private static final String UPDATE_USERS_SQL = "update User set Name = ?,Email= ?, PhoneNumber =? where Id = ?;";
    private static final String SELECT_USER_UPDATE = "select Id,Name , Email,PhoneNumber,PassWord from User where Id = ?;";
    private static final String SELECT_PROFILE_USER = "select Id,Name , Email,PhoneNumber,PassWord from User where Email = ? and PassWord = ? ";
    private static final String SELECT_ALL_USER = "select * from User ";
    private static final String DELETE_USER = "delete from User where Id = ?  ";
    private static final String SELECT_ID_USER = "select Id from User where Email = ?  and PassWord = ? " ;



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
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, passWord);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public UserDAO(){

    }
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(ConnectUrl,userName,passWord);
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

    public void editPassWordUser(int id, String password) throws SQLException, ClassNotFoundException {
        Connection connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD_USER);
        preparedStatement.setString(1,password);
        preparedStatement.setInt(2,id);
        preparedStatement.executeUpdate();
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
            String PassWord = resultSet.getString("PassWord");
            list.add(new User(Id,Name,Email,PhoneNumber,PassWord));
        }
        return list;
    }


    @Override
    public List<User> selectProfileUser(String email ,String passWord) throws SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROFILE_USER);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, passWord);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int Id = resultSet.getInt("Id");
            String Name = resultSet.getString("Name");
            String Email = resultSet.getString("Email");
            String PassWord = resultSet.getString("PassWord");
            int PhoneNumber = resultSet.getInt("PhoneNumber");
            list.add(new User(Id,Name,Email,PhoneNumber,PassWord));
        }
        return list;
    }

    @Override
    public List<User> selectAllUser() throws SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        Connection connection = connection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_USER);
        while (resultSet.next()){
            int Id = resultSet.getInt("Id");
            String Name = resultSet.getString("Name");
            String Email = resultSet.getString("Email");
            String PassWord = resultSet.getString("PassWord");
            int PhoneNumber = resultSet.getInt("PhoneNumber");
            list.add(new User(Id,Name,Email,PhoneNumber,PassWord));
        }
        return list;
    }

    @Override
    public void deleteUser(int Id) throws SQLException, ClassNotFoundException {
        Connection connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
        preparedStatement.setInt(1,Id);
        preparedStatement.executeUpdate();
    }

    @Override
    public User selectIdUser(String email, String password) throws SQLException, ClassNotFoundException {
        Connection connection = connection();
        User user = null;
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_USER);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int Id = resultSet.getInt("Id");
            user = new User(Id);
        }
        return user;

    }

}
