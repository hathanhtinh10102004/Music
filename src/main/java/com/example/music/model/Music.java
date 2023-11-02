package com.example.music.model;

public class Music {
    private int id;
    private String name;
    private String email;
    private int phoneNumber;
    private String passWord;

    public Music(String name, String email, int phoneNumber, String passWord){
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.passWord=passWord;
    }

    public Music(int id, String name, String email, String phoneNumber, String passWord) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = Integer.parseInt(phoneNumber);
        this.passWord = passWord;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
