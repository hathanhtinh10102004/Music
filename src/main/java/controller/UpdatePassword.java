package controller;

import Dao.IPlaylistDAO;
import Dao.IUserDAO;
import Dao.PlaylistDAO;
import Dao.UserDAO;
import model.Song;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet (name = "UpdatePassword", value = "/editPassWord")
public class UpdatePassword extends HttpServlet {
    IUserDAO iUserDAO;
    private IPlaylistDAO iPlaylistDAO;

    @Override
    public void init() {
        iUserDAO = new UserDAO();
        iPlaylistDAO = new PlaylistDAO();
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
            case "updatePassword":
                try {
                    changePassword(req, resp);
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

    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");



        if (iUserDAO.findPasswordById(id, password)) {
            if (newPassword.equals(confirmPassword)) {
                iUserDAO.editPassWordUser(id, newPassword);
                // Hiển thị hộp thoại xác nhận
                String confirmMessage = "Bạn có muốn cập nhật mật khẩu không?";
                request.setAttribute("ConfirmMessage", confirmMessage);
                request.setAttribute("Id", id);
                request.setAttribute("NewPassword", newPassword);
                User user = new User(email,newPassword);
                request.setAttribute("user",user);
                List<Song> list = iPlaylistDAO.selectAllPlaylist();
                request.setAttribute("list", list);
                request.getRequestDispatcher("Home.jsp").forward(request, response);
            } else {
                request.setAttribute("Message", "Error Password");
                request.getRequestDispatcher("editPassWord.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("Message", "Wrong Id or password, please re-enter");
            request.getRequestDispatcher("editPassWord.jsp").forward(request, response);
        }
    }
}








