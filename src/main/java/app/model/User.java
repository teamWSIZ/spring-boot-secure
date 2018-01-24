package app.model;

public class User {
    Integer userid;
    String name;
    String phone;


    public User() {
    }

    public User(Integer userid, String name, String phone) {
        this.userid = userid;
        this.name = name;
        this.phone = phone;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
