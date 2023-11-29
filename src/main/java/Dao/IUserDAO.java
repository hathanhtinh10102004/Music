package Dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public boolean findPasswordById(int id, String passWord) throws SQLException, ClassNotFoundException;

    public void editPassWordUser(int id, String password) throws SQLException, ClassNotFoundException;

    public boolean selectData(String email , String password) throws SQLException, ClassNotFoundException;
    public boolean updateUser(User user) throws SQLException, ClassNotFoundException;
    public List<User> selectUser(int idUser) throws SQLException, ClassNotFoundException;

    public List<User> selectProfileUser(String email ,String passWord) throws SQLException, ClassNotFoundException;

    public List<User> selectAllUser() throws SQLException, ClassNotFoundException;
    public void deleteUser(int Id) throws SQLException, ClassNotFoundException;
    public User selectIdUser(String email,String password) throws SQLException, ClassNotFoundException;

}



