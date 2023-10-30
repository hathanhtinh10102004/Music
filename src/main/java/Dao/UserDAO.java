package Dao;

import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO implements IUserDAO {
    private String ConnectUrl = "jdbc:mysql://localhost:3306/WebMusic";
    private String userName = "root";
    private String passWord = "1";

    private static String ADD_USER = "insert into User (Name,Email,PhoneNumber,PassWord) values (?,?,?,?)";

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


}
