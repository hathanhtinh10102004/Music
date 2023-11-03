package com.example.music.controller;

import com.example.music.model.Music;
import com.example.music.service.MusicDAO;
import com.example.music.service.MusicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/register")
public class MusicServlet extends HttpServlet {
    private MusicService musicService;

    @Override
    public void init() {
        musicService = new MusicDAO();

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

        }
    }

    private void insertMusic(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int phoneNumber = Integer.parseInt(req.getParameter("phoneNumber"));
        String passWord = req.getParameter("passWord");

        Music music = new Music(name, email, phoneNumber, passWord);
        musicService.insertMusic(music);
        req.getRequestDispatcher("/test.jsp").forward(req,resp);
    }

}
