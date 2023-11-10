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

@WebServlet(name = "UpdatePassword", value = "/editPassWord")
public class UpdatePassword extends HttpServlet {
    public UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("updatePassword")) {
            req.getRequestDispatcher("editPassWord.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "updatePassword":
//                try {
//                    changePassword(req, resp);
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                } catch (ClassNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//                break;
            case "updatePasswords":
                try {
                    updatePasswords(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                break;
        }
    }

    private void updatePasswords(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String oldPassword = req.getParameter("oldpassword");
        String newPassword = req.getParameter("newpassword");
        String conPassword = req.getParameter("conpassword");
        User user = userDAO.seletepassword(id);
        String passwordUser = user.getRePassword();

        if (passwordUser.equals(oldPassword)) {
            if (conPassword.equals(newPassword)) {
                userDAO.updatePassword(id, newPassword);
                req.setAttribute("id", id);
                req.getRequestDispatcher("listUser.jsp").forward(req, resp);
            } else {
                req.setAttribute("id", id);
                req.setAttribute("message", "Passwords do not match");
                req.getRequestDispatcher("editPassWord.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("id", id);
            req.setAttribute("message", "Incorrect password");
            req.getRequestDispatcher("editPassWord.jsp").forward(req, resp);
        }
    }

}

//    private void changePassword (HttpServletRequest request, HttpServletResponse response ) throws SQLException, ClassNotFoundException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String password = request.getParameter("passWord");
//        String newPassword = request.getParameter("newPassword");
//        String confirmPassword = request.getParameter("confirmPassword");
//        if (userDAO.findPasswordById(id,password)) {
//            if (newPassword.equals(confirmPassword)) {
//                userDAO.updatePassword(id, newPassword);
//                userDAO.findPasswordById(id,newPassword);
//                request.setAttribute("Message","Update Success");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//            } else {
//                request.setAttribute("Message","Error Password");
//                request.getRequestDispatcher("editPassWord.jsp").forward(request,response);
//            }
//        } else {
//            request.setAttribute("Message","Wrong Id or password, please re-enter");
//            request.getRequestDispatcher("editPassWord.jsp").forward(request,response);
//        }
//    }
//}


//    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String newPassword = request.getParameter("newPassword");
//        String confirmPassword = request.getParameter("confirmPassword");
//        User user = iUserDAO.editPasswordByEmail(id, password);
//        String passwordUser = user.getRePassword();
//        if (passwordUser.equals(password)) {
//            if (confirmPassword.equals(newPassword)){
//            iUserDAO.editPasswordByEmail(id, newPassword);
//            // Hiển thị hộp thoại xác nhận
//            String confirmMessage = "Bạn có muốn cập nhật mật khẩu không?";
//            request.setAttribute("ConfirmMessage", confirmMessage);
//            request.setAttribute("email", email);
//            request.setAttribute("newPassword", newPassword);
//            request.getRequestDispatcher("confirmUpdatePassword.jsp").forward(request, response);
//        } else {
//            request.setAttribute("Message", "Error: Passwords do not match");
//            request.getRequestDispatcher("editPassWord.jsp").forward(request, response);
//        }
//    } else
//
//    {
//        request.setAttribute("Message", "Wrong email or password, please re-enter");
//        request.getRequestDispatcher("editPassWord.jsp").forward(request, response);
//    }
//}







