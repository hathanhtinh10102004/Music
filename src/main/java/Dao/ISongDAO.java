package Dao;

import model.Song;

import java.sql.SQLException;
import java.util.List;

public interface ISongDAO {
    public List<Song> selectNameSong(String name) throws SQLException, ClassNotFoundException, SQLException;
    public boolean checkNameSong(String name) throws SQLException, ClassNotFoundException;
}
