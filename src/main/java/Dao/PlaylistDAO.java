package Dao;

import model.Playlist;
import model.Song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class PlaylistDAO implements IPlaylistDAO{
    private String ConnectUrl = "jdbc:mysql://localhost:3306/WebMusic";
    private String userName = "root";
    private String passWord = "1";

    private static final String SELECT_ALL_PLAYLIST = "select * from AddMusic";


    public Connection connection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = getConnection(ConnectUrl, userName, passWord);
        return connection;
    }


    @Override
    public List<Song> selectAllPlaylist() {
        List<Song> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PLAYLIST);
            while (resultSet.next()){
                String songName = resultSet.getString("songName");
                String singer = resultSet.getString("singer");
                String mp3_file_path = resultSet.getString("mp3_file_path");
                String image = resultSet.getString("image");
                list.add(new Song(songName,singer,mp3_file_path,image));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}


