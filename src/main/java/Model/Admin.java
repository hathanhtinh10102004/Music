package Model;

public class Admin {
    private int Id;
    private String Name;
    private String Email;
    private int PhoneNumber;

    public Admin(int id, String name, String email, int phoneNumber) {
        Id = id;
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
    }

    public Admin() {

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
}
