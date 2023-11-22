package Controller;

import DAO.AdminDAO;
import Model.Playlist;
import Model.Song;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="SonglistServlet", value= "/listSong" )
public class SongTopLikeServlet extends HttpServlet {
    private AdminDAO adminDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gọi phương thức từ DAO để lấy danh sách playlist đã được sắp xếp theo lượt like
        AdminDAO playlistDAO = new AdminDAO();
        List<Song> songs = playlistDAO.getTopLikedSong();

        // Truyền danh sách playlist đến trang JSP
        request.setAttribute("songs", songs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/song_Lists.jsp");
        dispatcher.forward(request, response);
    }
}
