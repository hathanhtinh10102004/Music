package controller;

import Dao.AdminDAO;
import Dao.IAdmin;
import com.example.music.HelloServlet;
import model.Admin;

import javax.servlet.RequestDispatcher;
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

    public void init() {
        iAdmin = new AdminDAO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        System.out.println(action);

        switch (action) {
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

    private void listAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Admin> list = iAdmin.selectAdmin();
        request.setAttribute("list", list);
        request.getRequestDispatcher("Admin.jsp").forward(request, response);
    }
}
