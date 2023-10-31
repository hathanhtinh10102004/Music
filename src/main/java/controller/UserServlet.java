package controller;

import Dao.IUserDAO;
import Dao.UserDAO;
import com.example.music.HelloServlet;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "UserServlet" , value = "/user")
public class UserServlet extends HelloServlet {
    private IUserDAO iUserDAO;

    public void init(){
        iUserDAO = new UserDAO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        System.out.println(action);

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
        }

    }

    private void loginUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (iUserDAO.selectData(email,password)){
            System.out.println("dang nhap thanh cong");
        }else {
            req.setAttribute("message","tai khoan khong ton tai !");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}


