package Dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public boolean selectData(String email , String password) throws SQLException, ClassNotFoundException;
}


