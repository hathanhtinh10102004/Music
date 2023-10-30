package Dao;

import model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements IAdmin{
    private String url = "jdbc:mysql://localhost:3306/WebMusic";
    private String username = "root";
    private String password = "2004";

    private static final String SELECT_ALL_ADMIN = "select * from Admin";

    public AdminDAO(){

    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,username,password);
        return connection;
    }


    @Override
    public List<Admin> selectAdmin() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        List<Admin> list = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_ADMIN);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int phoneNumber = resultSet.getInt("phoneNumber");
            list.add(new Admin(id,name,email,phoneNumber));
        }
        return list;
    }
}
