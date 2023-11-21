package Dao;

import model.Singer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingerDAO implements ISingerDAO {
    private String ConnectUrl = "jdbc:mysql://localhost:3306/WebMusic";
    private String userName = "root";
    private String passWord = "2004";

    private static final String SELECT_NAME_SINGER = "select nameSinger from Singer where nameSinger like ? ";
    private static final String CHECK_NAME_SINGER = "select nameSinger from Singer where nameSinger like ? ";


    public Connection connection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(ConnectUrl, userName, passWord);
        return connection;
    }

    public SingerDAO() {

    }

    @Override
    public List<Singer> selectNameSinger(String name) throws SQLException, ClassNotFoundException {
        List<Singer> list = new ArrayList<>();
        Connection connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NAME_SINGER);
        preparedStatement.setString(1, "%"+name+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String nameSinger = resultSet.getString("nameSinger");
            list.add( new Singer(nameSinger));
        }
        return list;
    }

    @Override
    public boolean checkNameSinger(String name) throws SQLException, ClassNotFoundException {
        Connection connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(CHECK_NAME_SINGER);
        preparedStatement.setString(1, "%"+name+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
