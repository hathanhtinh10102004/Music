package Dao;

import model.User;

import java.sql.*;

public class UserDAO implements IUserDAO {
    private String ConnectUrl = "jdbc:mysql://localhost:3306/WebMusic";
    private String userName = "root";
    private String passWord = "2004";


    public Connection connection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(ConnectUrl, userName, passWord);
        return connection;
    }


}