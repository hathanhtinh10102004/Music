package controller;

import Dao.PlaylistDAO;
import model.Playlist;
import model.Song;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name="PlaylistServlet",value = "/songList")
public class PlaylistServlet extends HttpServlet {
    private PlaylistDAO playlistDAO;

    @Override
    public void init() {
        playlistDAO = new PlaylistDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "listMusic":
                listPlaylist(req, resp);
                break;
        }
    }


    private void listPlaylist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Song> list = playlistDAO.selectAllPlaylist();
        req.setAttribute("list", list);
        req.getRequestDispatcher("songList.jsp").forward(req,resp);
    }
}