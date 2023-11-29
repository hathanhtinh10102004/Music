package Dao;

import model.Singer;

import java.sql.SQLException;
import java.util.List;

public interface ISingerDAO {
    public List<Singer> selectNameSinger(String name) throws SQLException, ClassNotFoundException;
    public boolean checkNameSinger(String name) throws SQLException, ClassNotFoundException, SQLException;
}
