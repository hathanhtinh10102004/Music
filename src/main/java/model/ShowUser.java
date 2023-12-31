package model;

public class ShowUser {
//    Id int primary key auto_increment,
//    Name varchar(100),
//    Email varchar(100),
//    PhoneNumber int (10),
//    PassWord varchar (100)
    private int Id;
    private String Name;
    private String Email;
    private int PhoneNumber;
    private String PassWord;

    public ShowUser(int id, String name, String email, int phoneNumber, String passWord) {
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
