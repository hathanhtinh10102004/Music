package com.example.music.service;

import com.example.music.model.Music;

import java.sql.SQLException;

public interface MusicService {
    public void insertMusic(Music music) throws SQLException;
}
