package controller;

import Dao.CreateSongsDAO;
import Dao.PlaylistDAO;
import model.Playlist;
import model.Song;

import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

import static jdk.jpackage.internal.IOUtils.getFileName;

@WebServlet(name = "CreateSongServlet", value = "/CreateSongServlet")
@MultipartConfig
public class CreateSongServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CreateSongsDAO createSongsDAO;
    private PlaylistDAO playlistDAO;

    @Override
    public void init() {
        createSongsDAO = new CreateSongsDAO();
        playlistDAO = new PlaylistDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("create_song.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addSong":
                try {
                    addSong(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void addSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String songName = request.getParameter("songName");
        System.out.println(songName);
        String singer = request.getParameter("singer");
        String description = request.getParameter("description");
        Part mp3Part = request.getPart("mp3File");
        Part imagePart = request.getPart("imageFile");

        String mp3FileName = mp3Part.getSubmittedFileName();
        String imageFileName = imagePart.getSubmittedFileName();

        String mp3FilePath = "/path/to/mp3/directory/" + mp3FileName;
        String imageFilePath = "/path/to/image/directory/" + imageFileName;


        Song song = new Song(songName, singer, description, mp3FilePath, imageFilePath);

        createSongsDAO.addSong(song);

        List<Song> list = playlistDAO.selectAllPlaylist();
        request.setAttribute("list", list);
        request.getRequestDispatcher("songList.jsp").forward(request, response);


    }


}