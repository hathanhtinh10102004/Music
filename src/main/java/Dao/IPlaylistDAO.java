package Dao;

import model.Playlist;
import model.Song;

import java.util.List;

public interface IPlaylistDAO {
    public List<Song> selectAllPlaylist();
}
