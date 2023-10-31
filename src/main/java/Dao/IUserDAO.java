package Dao;

import model.User;

import java.sql.SQLException;

public interface IUserDAO {
    public boolean findPasswordById(int id, String passWord) throws SQLException, ClassNotFoundException;

    public void editPassWordUser(int id, String password) throws SQLException, ClassNotFoundException;

}
