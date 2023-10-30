package model;

public class User {
    private int Id;
    private String Name;
    private String Email;
    private int PhoneNumber;
    private String PassWord;
    public User(String name, String email, int PhoneNumber, String PassWord){
        this.Name = name;
        this.Email = email;
        this.PhoneNumber = PhoneNumber;
        this.PassWord = PassWord;
    }

    public User(int id, String name, String email, int phoneNumber, String passWord) {
        Id = id;
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
        PassWord = passWord;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
}
