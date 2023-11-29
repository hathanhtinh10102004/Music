package Dao;

import model.Playlist;
import model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class PlaylistDAO implements IPlaylistDAO {
    private String ConnectUrl = "jdbc:mysql://localhost:3306/WebMusic";
    private String userName = "root";
    private String passWord = "2004";

    private static final String SELECT_ALL_PLAYLIST = "select * from AddMusic";
    private static final String SELECT_SONG = "select * from AddMusic where id = ? ";
    private static final String UPDATE_SONG = "update AddMusic set songName = ? , singer = ? where id = ?  ";

    private static final String DELETE_CART_SQL = "delete from AddMusic where id = ?;";
    private static final String SELECT_CART = "select * from AddMusic";
    private static final String SEARCH = "select songName,singer,image from AddMusic where songName like ? or singer like ? ";


    public Connection connection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = getConnection(ConnectUrl, userName, passWord);
        return connection;
    }


    @Override
    public List<Song> selectAllPlaylist() throws SQLException, ClassNotFoundException {
        List<Song> list = new ArrayList<>();
        Connection connection = connection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_PLAYLIST);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String songName = resultSet.getString("songName");
            String singer = resultSet.getString("singer");
            String mp3_file_path = resultSet.getString("mp3_file_path");
            String image = resultSet.getString("image");
            list.add(new Song(id, songName, singer, mp3_file_path, image));
        }
        return list;
    }

    @Override
    public List<Song> selectSong(int x) {
        List<Song> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SONG);
            preparedStatement.setInt(1,x);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String songName = resultSet.getString("songName");
                String singer = resultSet.getString("singer");
                String description = resultSet.getString("description");
                String listen = resultSet.getString("listen");
                String mp3_file_path = resultSet.getString("mp3_file_path");
                String image = resultSet.getString("image");
                list.add(new Song(id, songName, singer,description,listen, mp3_file_path, image));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void updateSong(Song song) throws SQLException, ClassNotFoundException {
        Connection connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SONG);
        preparedStatement.setInt(3, song.getId());
        preparedStatement.setString(1, song.getSongName());
        preparedStatement.setString(2, song.getSinger());
        preparedStatement.executeUpdate();

    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted;
        try (Connection connection = connection()) {
            try (PreparedStatement statement = connection.prepareStatement(DELETE_CART_SQL)) {
                statement.setInt(1, id);
                rowDeleted = statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public List<Song> SelectSong() throws SQLException, ClassNotFoundException {
        List<Song> list = new ArrayList<>();
        Connection connection = connection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_CART);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String songName = resultSet.getString("songName");
            String singer = resultSet.getString("singer");
            String description = resultSet.getString("description");
            String listen = resultSet.getString("listen");
            String image = resultSet.getString("image");

            String mp3_file_path = resultSet.getString("mp3_file_path");
            list.add(new Song(id, songName, singer, description, image, listen, mp3_file_path));

        }
        return list;
    }

    @Override
    public List<Song> search(String find) throws SQLException, ClassNotFoundException {
        Connection connection = connection();
        List<Song> list = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
        preparedStatement.setString(1,"%"+find+"%");
        preparedStatement.setString(2,"%"+find+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
           String  songName = resultSet.getString("songName");
           String singer = resultSet.getString("singer");
           String image = resultSet.getString("image");
           list.add(new Song(songName,singer,image));
        }
        return list;

    }

    @Override
    public boolean checkSearch(String find) throws SQLException, ClassNotFoundException {
        Connection connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
        System.out.println(find);
        preparedStatement.setString(1,"%"+find+"%");
        preparedStatement.setString(2,"%"+find+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();

    }


}


