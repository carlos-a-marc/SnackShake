package br.com.snackshake.model.vo;

/**
 *
 * @author Carlos
 */
public class ClienteVO {

    private String name;
    private String user;
    private String mail;
    private String password;
    private String phone;
    private String photo;

    public ClienteVO(String name, String user, String mail, String password, String phone, String photo) {
        this.name = name;
        this.user = user;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
