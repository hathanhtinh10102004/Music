package DAO;

import Model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements IAdmin{
   public static Connect connect = new Connect();

    public static List<User> getAllUser() throws SQLException{
        String query = "SELECT * FROM WebMusic.User";
        List<User> userList = new ArrayList<>();
        try{
        PreparedStatement statement = connect.connect().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int Id = resultSet.getInt("Id");
            String Name = resultSet.getString("Name");
            String Email = resultSet.getString("Email");
            Integer PhoneNumber = resultSet.getInt("PhoneNumber");
            User user = new User();
            user.setId(Id);
            user.setName(Name);
            user.setEmail(Email);
            user.setPhoneNumber(PhoneNumber);
            userList.add(user);

        }
        }catch (SQLException e) {
            e.printStackTrace();

        }

        return userList;
    }

    @Override
    public void deleteUser(int Id) throws SQLException, ClassNotFoundException {

        String query = "DELETE FROM User WHERE id = ? ";
       try{
           PreparedStatement statement = connect.connect().prepareStatement(query);
           statement.setInt(1,Id);
           statement.executeUpdate();
       }catch (SQLException e) {
           e.printStackTrace();
    }



}
}