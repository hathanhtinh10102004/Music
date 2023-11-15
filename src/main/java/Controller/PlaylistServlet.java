package Controller;

import DAO.AdminDAO;
import DAO.IAdmin;
import Model.Playlist;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
@WebServlet (name="PlaylistServlet", value= "/playlist" )
public class PlaylistServlet extends HttpServlet {


    private AdminDAO adminDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gọi phương thức từ DAO để lấy danh sách playlist đã được sắp xếp theo lượt like
        AdminDAO playlistDAO = new AdminDAO();
        List<Playlist> playlists = playlistDAO.getTopLikedPlaylists();

        // Truyền danh sách playlist đến trang JSP
        request.setAttribute("playlists", playlists);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/test_Playlist.jsp");
        dispatcher.forward(request, response);
    }
}
