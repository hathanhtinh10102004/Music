package Model;

public class Song {
    private String creatorName;
    private int likeCount;
    private String nameSong;
    private String listens;
    private String imageUrl;

    public Song() {
    }

    public Song(String creatorName, int likeCount, String nameSong, String listens, String imageUrl) {
        this.creatorName = creatorName;
        this.likeCount = likeCount;
        this.nameSong = nameSong;
        this.listens = listens;
        this.imageUrl = imageUrl;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getListens() {
        return listens;
    }

    public void setListens(String listens) {
        this.listens = listens;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
