package model;

public class Playlist {
    private String creator;
    private String nameSong;
    private String listens;
    private String img;


    public Playlist(){}
    public Playlist(String creator,String nameSong, String listens,String img){
        this.creator = creator;
        this.nameSong = nameSong;
        this.listens = listens;
        this.img = img;
    }

    public Playlist(String songName, String singer) {
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {

        this.creator = creator;
    }

    public String getNameSong() {

        return nameSong;
    }

    public void setNameSong(String nameSongs) {
        this.nameSong = nameSong;
    }

    public String getListens() {

        return listens;
    }

    public void setListens(String listens) {

        this.listens = listens;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

