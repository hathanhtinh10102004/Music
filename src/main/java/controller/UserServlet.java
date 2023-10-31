package controller;

import Dao.IUserDAO;
import Dao.UserDAO;
import com.example.music.HelloServlet;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "UserServlet" , value = "/user")
public class UserServlet extends HelloServlet {
    private UserDAO userDAO;

    public void init(){
        userDAO = new UserDAO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        System.out.println(action);
        switch (action){
            case "exit":

                break;
            default:
                try {
                    showEdit(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action) {
            case "login" :
                try {
                    loginUser(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    updateUser(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = 1;
        List<User> list = userDAO.selectUser(id);
        request.setAttribute("list" , list);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }


    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int phoneNumber = Integer.parseInt(req.getParameter("phoneNumber"));
        User user = new User(id,name,email,phoneNumber);
        userDAO.updateUser(user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        dispatcher.forward(req,resp);
    }

    private void loginUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (userDAO.selectData(email,password)){
            System.out.println("dang nhap thanh cong");
        }else {
            req.setAttribute("message","tai khoan khong ton tai !");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}

