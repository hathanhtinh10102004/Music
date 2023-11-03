package DAO;


import Model.Admin;
import Model.User;

import java.sql.SQLException;
import java.util.List;

public interface IAdmin {
    public static List<User> getAllUser() throws SQLException {
        return null;
    }

    void deleteUser(int Id) throws SQLException, ClassNotFoundException;
}
