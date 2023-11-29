package controller;

import Dao.AdminDAO;
import Dao.IAdmin;
import Dao.IUserDAO;
import Dao.UserDAO;
import com.example.music.HelloServlet;
import model.Admin;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admin")

public class AdminServlet extends HelloServlet {

    private IAdmin iAdmin;
    private IUserDAO iUserDAO;

    public void init() {
        iAdmin = new AdminDAO();
        iUserDAO = new UserDAO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        System.out.println(action);

        switch (action) {
            case "showUser" :
                try {
                    showFormUser(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete" :
                try {
                    deleteUser(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "back" :
                try {
                    back(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                break;

            default:
                try {
                    listAdmin(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException | ServletException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void back(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        List<User> list= iUserDAO.selectProfileUser(email,password);
        request.setAttribute("list",list);
        User user = new User(email, password);
        request.setAttribute("user", user);
        request.getRequestDispatcher("Home.jsp").forward(request,response);

    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        int id = Integer.parseInt(request.getParameter("id"));
        iUserDAO.deleteUser(id);


        User user = new User(email,password);
        request.setAttribute("user",user);

        List<User> list = iUserDAO.selectAllUser();
        request.setAttribute("listUser",list);
        request.getRequestDispatcher("Admin.jsp").forward(request,response);


    }

    private void showFormUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(email,password);
        List<User> list = iUserDAO.selectAllUser();
        request.setAttribute("listUser",list);

        request.setAttribute("user",user);
        request.getRequestDispatcher("Admin.jsp").forward(request,response);
    }

    private void listAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Admin> list = iAdmin.selectAdmin();
        request.setAttribute("list", list);
        request.getRequestDispatcher("Admin.jsp").forward(request, response);
    }
}
