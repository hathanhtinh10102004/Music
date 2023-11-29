package Dao;

import model.Admin;

import java.sql.SQLException;
import java.util.List;

public interface IAdmin {
    List<Admin> selectAdmin() throws SQLException, ClassNotFoundException;
}
