package controller;

import Dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddUser", value = "/addUser")
public class AddUser extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int  phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        String password = request.getParameter("password");

        String emailOld = request.getParameter("emailOld");
        String passwordOld = request.getParameter("passwordOld");


        User user = new User(name,email,phoneNumber,password);


        try {
            userDAO.addUser(user);

            User user1 = new User(emailOld,passwordOld);
            List<User> list1 = userDAO.selectAllUser();
            request.setAttribute("listUser",list1);

            request.setAttribute("user",user1);
            request.setAttribute("add","Them thanh cong!");
            request.getRequestDispatcher("Admin.jsp").forward(request,response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
