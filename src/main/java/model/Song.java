package model;

public class Song {
    private int idSong;
    private String nameSong;
    private String Release_Date;
    private String Time ;

    public Song(int idSong, String nameSong, String release_Date, String time) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        Release_Date = release_Date;
        Time = time;
    }

    public Song(String nameSong) {
        this.nameSong = nameSong;

    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getRelease_Date() {
        return Release_Date;
    }

    public void setRelease_Date(String release_Date) {
        Release_Date = release_Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
