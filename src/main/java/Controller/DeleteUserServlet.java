package Controller;

import DAO.AdminDAO;
import DAO.IAdmin;
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

@WebServlet (name= "DeleteUserServlet", value = "/delete")
public class DeleteUserServlet extends HttpServlet {
    private AdminDAO adminDAO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int Id = Integer.parseInt(request.getParameter("Id"));
            AdminDAO adminDAO1 = new AdminDAO();
            adminDAO1.deleteUser(Id);
            response.sendRedirect("/userManagement");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
