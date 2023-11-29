package controller;

import Dao.*;
import model.Singer;
import model.Song;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "SingerServlet", value = "/singer")
public class SingerServlet extends HttpServlet {

    private ISingerDAO iSingerDAO;
    private IPlaylistDAO iPlaylistDAO;

    @Override
    public void init() throws ServletException {
        iSingerDAO = new SingerDAO();
        iPlaylistDAO = new PlaylistDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                try {
                    findSinger(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void findSinger(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String find = req.getParameter("find");
        System.out.println(find);
        if ("".equals(find)){
            req.setAttribute("song","This singer or song is not available !");
            req.getRequestDispatcher("Home.jsp").forward(req,resp);
        }else {
            if (iPlaylistDAO.checkSearch(find)) {
                List<Song> list = iPlaylistDAO.search(find);
                req.setAttribute("list", list);
                req.getRequestDispatcher("singer.jsp").forward(req, resp);
            } else {
                req.setAttribute("song","This singer or song is not available !");
                req.getRequestDispatcher("Home.jsp").forward(req,resp);
            }
        }


    }
}
