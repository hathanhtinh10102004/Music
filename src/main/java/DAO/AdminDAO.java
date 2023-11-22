package DAO;

import Model.Playlist;
import Model.Song;
import Model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AdminDAO implements IAdmin {
    public static Connect connect = new Connect();

    public static List<User> getAllUser() throws SQLException {
        String query = "SELECT * FROM WebMusic.User";
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement statement = connect.connect().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int Id = resultSet.getInt("Id");
                String Name = resultSet.getString("Name");
                String Email = resultSet.getString("Email");
                Integer PhoneNumber = resultSet.getInt("PhoneNumber");
                User user = new User();
                user.setId(Id);
                user.setName(Name);
                user.setEmail(Email);
                user.setPhoneNumber(PhoneNumber);
                userList.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return userList;
    }

    @Override
    public void deleteUser(int Id) throws SQLException, ClassNotFoundException {

        String query = "DELETE FROM User WHERE id = ? ";
        try {
            PreparedStatement statement = connect.connect().prepareStatement(query);
            statement.setInt(1, Id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static List<Playlist>  getTopLikedPlaylists() {
            List<Playlist> playlists = new ArrayList<>();
            try {
                // Kết nối đến cơ sở dữ liệu
                Connection connection = connect.connect();

                // Tạo câu lệnh truy vấn SQL
                String sql = "SELECT * FROM AddMusic ORDER BY like_count DESC LIMIT 8";
                PreparedStatement statement = connection.prepareStatement(sql);

                // Thực hiện truy vấn
                ResultSet resultSet = statement.executeQuery();

                // Xử lý kết quả truy vấn
                while (resultSet.next()) {
                    String creatorName = resultSet.getString("creator");
                    int likeCount = resultSet.getInt("like_count");
                    String nameSong = resultSet.getString("namesong");
                    String listens = resultSet.getString("listens");
                    String imageUrl = resultSet.getString("img");


                    Playlist playlist = new Playlist( creatorName,likeCount,nameSong,listens,imageUrl);
                    playlists.add(playlist);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

            return playlists;
        }

    public static List<Song> getTopLikedSong() {
        List<Song> songs = new ArrayList<>();
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = connect.connect();

            // Tạo câu lệnh truy vấn SQL
            String sql = "SELECT * FROM AddMusic ORDER BY like_count DESC LIMIT 8";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Thực hiện truy vấn
            ResultSet resultSet = statement.executeQuery();

            // Xử lý kết quả truy vấn
            while (resultSet.next()) {
                String creatorName = resultSet.getString("creator");
                int likeCount = resultSet.getInt("like_count");
                String nameSong = resultSet.getString("namesong");
                String listens = resultSet.getString("listens");
                String imageUrl = resultSet.getString("img");


                Song song = new Song( creatorName,likeCount,nameSong,listens,imageUrl);
                songs.add(song);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return songs;
    }
    }
