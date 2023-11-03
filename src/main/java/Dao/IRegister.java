package Dao;

import model.User;

import java.sql.SQLException;

public interface IRegister {
    void insertMusic(User user) throws SQLException;
}
