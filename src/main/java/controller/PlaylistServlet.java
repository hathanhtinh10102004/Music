package controller;

import Dao.IUserDAO;
import Dao.PlaylistDAO;
import Dao.UserDAO;
import model.Playlist;
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


@WebServlet(name="PlaylistServlet",value = "/songList")
public class PlaylistServlet extends HttpServlet {
    private PlaylistDAO playlistDAO;
    private IUserDAO iUserDAO;

    @Override
    public void init() {
        playlistDAO = new PlaylistDAO();
        iUserDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "listMusic":
                try {
                    listPlaylist(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
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
            case "update" :
                formUpdate(req,resp);
                break;
            case "confirm" :
                try {
                    confirmUpdate(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                try {
                    delete(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "profile" :
                showProfile(req,resp);
                break;
        }
    }

    private void showProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(email,password);
        req.setAttribute("user",user);

        List<Song> list =  playlistDAO.selectSong(id);
        req.setAttribute("list",list);

        req.getRequestDispatcher("showProfile.jsp").forward(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(req.getParameter("id"));

        playlistDAO.delete(id);
        List<Song> list = playlistDAO.selectAllPlaylist();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/songList.jsp").forward(req, resp);


    }

    private void confirmUpdate(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String songName = req.getParameter("songName");
        String singer = req.getParameter("singer");

        Song song = new Song(id,songName,singer);
        playlistDAO.updateSong(song);

        List<Song> list = playlistDAO.selectAllPlaylist();
        req.setAttribute("list", list);
        req.setAttribute("update","update thanh cong!");
        req.getRequestDispatcher("songList.jsp").forward(req,resp);


    }

    private void formUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(email,password);
        req.setAttribute("user",user);

        List<Song> list = playlistDAO.selectSong(id);
        req.setAttribute("list", list);
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }

    private void listPlaylist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(email,password);
        req.setAttribute("user",user);
        List<Song> list = playlistDAO.selectAllPlaylist();
        req.setAttribute("list", list);
        req.getRequestDispatcher("songList.jsp").forward(req,resp);
    }
}