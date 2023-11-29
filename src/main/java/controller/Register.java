package controller;

import Dao.RegisterDAO;
import Dao.IRegister;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet(value = "/register")
public class Register extends HttpServlet {
    private IRegister iRegister;
    @Override
    public void init() {
        iRegister = new RegisterDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register":
                try {
                    insertMusic(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

        }
    }

    private void insertMusic(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int phoneNumber = Integer.parseInt(req.getParameter("phoneNumber"));
        String password = req.getParameter("password");

        User user = new User(name, email, phoneNumber, password);
        iRegister.insertMusic(user);
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

}
