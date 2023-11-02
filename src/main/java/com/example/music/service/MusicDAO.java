package com.example.music.service;

import com.example.music.model.Music;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MusicDAO implements MusicService{
    private String jdbcURL = "jdbc:mysql://localhost:3306/WebMusic";
    private  String jdbcUsername = "root";
    private  String jdbcPassword ="password";

    public MusicDAO(){}

    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }
    private static final String INSERT_User_SQL = "INSERT INTO User( Name, Email,PhoneNumber,PassWord) VALUE (?,?,?,?)";

    @Override
    public void insertMusic(Music music) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_User_SQL);
        preparedStatement.setString(1, music.getName());
        preparedStatement.setString(2,music.getEmail());
        preparedStatement.setInt(3,music.getPhoneNumber());
        preparedStatement.setString(4,music.getPassWord());
        preparedStatement.executeUpdate();

    }
}
