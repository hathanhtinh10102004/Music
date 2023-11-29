package Dao;

import model.Playlist;
import model.Song;

import java.sql.SQLException;
import java.util.List;

public interface IPlaylistDAO {
    public List<Song> selectAllPlaylist() throws SQLException, ClassNotFoundException;
    public List<Song> selectSong(int id);
    public void updateSong(Song song) throws SQLException, ClassNotFoundException;
    public boolean delete(int id);
    public List<Song> SelectSong() throws SQLException, ClassNotFoundException;
    public List<Song> search(String find) throws SQLException, ClassNotFoundException;
    public boolean checkSearch(String find) throws SQLException, ClassNotFoundException;

}
