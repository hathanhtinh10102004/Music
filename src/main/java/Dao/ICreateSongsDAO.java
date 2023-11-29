package Dao;

import model.Song;

import java.sql.SQLException;

public interface ICreateSongsDAO {
    void addSong(Song song) throws SQLException, ClassNotFoundException ;

}
