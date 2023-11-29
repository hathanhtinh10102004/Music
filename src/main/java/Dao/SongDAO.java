package Dao;

import model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDAO implements ISongDAO{
    private String ConnectUrl = "jdbc:mysql://localhost:3306/WebMusic";
    private String userName = "root";
    private String passWord = "2004";

    private static final String SELECT_NAME_SONG  = "select nameSong from Song where Songcol like ? ";
    private static final String CHECK_NAME_SONG = "select nameSong from Song where nameSong like ? ";


    public Connection connection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(ConnectUrl, userName, passWord);
        return connection;
    }

    public SongDAO(){

    }

    @Override
    public List<Song> selectNameSong(String name) throws ClassNotFoundException, SQLException {
        List<Song> list = new ArrayList<>();
        Connection connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NAME_SONG);
        preparedStatement.setString(1, "%"+name+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String nameSong = resultSet.getString("nameSong");
            list.add(new Song(nameSong));
        }
        return list ;
    }


    @Override
    public boolean checkNameSong(String name) throws ClassNotFoundException, SQLException {
        Connection connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(CHECK_NAME_SONG);
        preparedStatement.setString(1, "%"+name+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

}
