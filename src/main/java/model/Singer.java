package model;

public class Singer {

    private int  idSinger ;
    private String nameSinger;
    private String Date_of_Birth ;
    private String img ;

    public Singer(int idSinger, String nameSinger, String date_of_Birth, String img) {
        this.idSinger = idSinger;
        this.nameSinger = nameSinger;
        Date_of_Birth = date_of_Birth;
        this.img = img;
    }

    public Singer(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public int getIdSinger() {
        return idSinger;
    }

    public void setIdSinger(int idSinger) {
        this.idSinger = idSinger;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getDate_of_Birth() {
        return Date_of_Birth;
    }

    public void setDate_of_Birth(String date_of_Birth) {
        Date_of_Birth = date_of_Birth;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
