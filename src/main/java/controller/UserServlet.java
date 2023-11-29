package controller;

import Dao.IUserDAO;
import Dao.UserDAO;
import com.example.music.HelloServlet;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HelloServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "showUser":
                try {
                    showFormUser(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "login":
                try {
                    loginUser(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    updateUser(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "formEdit":
                try {
                    showEdit(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }

                break;

        }
    }

    private void showFormUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(email, password);
        List<User> list = userDAO.selectAllUser();
        request.setAttribute("listUser", list);

        request.setAttribute("user", user);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }


    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(email, password);


        request.setAttribute("user", user);
        List<User> list = userDAO.selectUser(id);
        request.setAttribute("list", list);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }


    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        System.out.println("tinh an lon");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int phoneNumber = Integer.parseInt(req.getParameter("phoneNumber"));
        User user = new User(id, name, email, phoneNumber);
        userDAO.updateUser(user);

        List<User> list = userDAO.selectUser(id);
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
        dispatcher.forward(req, resp);
    }

    private void loginUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (userDAO.selectData(email, password)) {
            User user1 = userDAO.selectIdUser(email,password);
            int Id = user1.getId();
            List<User> list = userDAO.selectProfileUser(email, password);
            req.setAttribute("list", list);
            User user = new User(Id,email, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            req.getRequestDispatcher("Home.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Account does not exist !");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}

