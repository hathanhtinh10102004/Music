package Controller;

import DAO.AdminDAO;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name= "ListUserServlet", value = "/userManagement")
public class ListUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<User> userList = new ArrayList<>();
            userList = AdminDAO.getAllUser();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("/View/listUser.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
