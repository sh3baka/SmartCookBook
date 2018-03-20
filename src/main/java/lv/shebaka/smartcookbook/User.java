package lv.shebaka.smartcookbook;


public class User {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String regDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : id != null) return false;
        if (username != null ? !username.equals(user.username) : username != null) return false;
        if (password != null ? !password.equals(user.password) : password != null) return false;
        if (email != null ? !email.equals(user.email) : email != null) return false;
        return regDate != null ? !regDate.equals(user.regDate) : regDate != null;

    }
}
