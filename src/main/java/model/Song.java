package model;

public class Song {
    private int id;
    private String songName ;
    private String singer;
    private String description;
    private  String listen;

    private String image ;
    private  String mp3_file_path;

    public Song(int id, String songName, String singer, String description, String listen, String image, String mp3_file_path) {
        this.id = id;
        this.songName = songName;
        this.singer = singer;
        this.description = description;
        this.listen = listen;
        this.image = image;
        this.mp3_file_path = mp3_file_path;
    }

    public Song(String songName, String singer, String description, String listen, String image, String mp3_file_path) {
        this.songName = songName;
        this.singer = singer;
        this.description = description;
        this.listen = listen;
        this.image = image;
        this.mp3_file_path = mp3_file_path;
    }

    public Song(String songName, String singer, String description, String mp3_file_path, String image) {
        this.songName = songName;
        this.singer = singer;
        this.description = description;
        this.image = image;
        this.mp3_file_path = mp3_file_path;
    }

    public Song(String nameSong) {
        this.songName = nameSong;
    }

    public Song(String songName, String singer, String image) {
        this.songName = songName;
        this.singer = singer;
        this.image = image;
    }

    public Song(String songName, String singer, String mp3FilePath, String image ) {
        this.songName = songName;
        this.singer = singer;
        this.image = image;
        this.mp3_file_path = mp3FilePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getListen() {
        return listen;
    }

    public void setListen(String listen) {
        this.listen = listen;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMp3_file_path() {
        return mp3_file_path;
    }

    public void setMp3_file_path(String mp3_file_path) {
        this.mp3_file_path = mp3_file_path;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", singer='" + singer + '\'' +
                ", description='" + description + '\'' +
                ", listen='" + listen + '\'' +
                ", image='" + image + '\'' +
                ", mp3_file_path='" + mp3_file_path + '\'' +
                '}';
    }
}
