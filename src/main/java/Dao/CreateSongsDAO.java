package Dao;

import model.Song;

import java.sql.*;

public class CreateSongsDAO implements ICreateSongsDAO {
    private String ConnectUrl = "jdbc:mysql://localhost:3306/WebMusic";
    private String userName = "root";
    private String passWord = "1";

    private static final String INSERT_SONG_SQL = "INSERT INTO AddMusic (songName,singer,description,image,mp3_file_path) VALUES (?, ?, ?,?,?)";


    public Connection connection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(ConnectUrl, userName, passWord);
        return connection;
    }

    public void addSong(Song song) throws SQLException, ClassNotFoundException {
        Connection connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SONG_SQL);
        preparedStatement.setString(1, song.getSongName());
        preparedStatement.setString(2, song.getSinger());
        preparedStatement.setString(3, song.getDescription());
        preparedStatement.setString(4, song.getImage());
        preparedStatement.setString(5, song.getMp3_file_path());
        preparedStatement.executeUpdate();


    }


}
