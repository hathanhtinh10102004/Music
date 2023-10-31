package Dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public boolean selectData(String email , String password) throws SQLException, ClassNotFoundException;
    public boolean updateUser(User user) throws SQLException, ClassNotFoundException;
    public List<User> selectUser(int idUser) throws SQLException, ClassNotFoundException;
}


