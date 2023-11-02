package controller;

import Dao.IUserDAO;
import Dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet (name = "UpdatePassword", value = "/editPassWord")
public class UpdatePassword extends HttpServlet {
    IUserDAO iUserDAO;
    @Override
    public void init(){
        iUserDAO= new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action  = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "updatePassword":
                try {
                    changePassword(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
    private void changePassword (HttpServletRequest request, HttpServletResponse response ) throws SQLException, ClassNotFoundException, ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        if (iUserDAO.findPasswordById(id,password)) {
            if (newPassword.equals(confirmPassword)) {
                System.out.println("doi thanh cong");
                iUserDAO.editPassWordUser(id,newPassword);
                request.setAttribute("Message","Update Success");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("Message","Error Password");
                request.getRequestDispatcher("editPassWord.jsp").forward(request,response);
            }
        } else {
            request.setAttribute("Message","Wrong Id or password, please re-enter");
            request.getRequestDispatcher("editPassWord.jsp").forward(request,response);
        }
    }
}
