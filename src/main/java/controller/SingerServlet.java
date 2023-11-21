package controller;

import Dao.ISingerDAO;
import Dao.ISongDAO;
import Dao.SingerDAO;
import Dao.SongDAO;
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
    private ISongDAO iSongDAO;

    @Override
    public void init() throws ServletException {
        iSingerDAO = new SingerDAO();
        iSongDAO = new SongDAO();
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
        List<Singer> listSinger = iSingerDAO.selectNameSinger(find);

        List<Song> listSong = iSongDAO.selectNameSong(find);

        req.setAttribute("listSinger", listSinger);
        req.setAttribute("listSong", listSong);
        req.getRequestDispatcher("singer.jsp").forward(req,resp);
    }
}
