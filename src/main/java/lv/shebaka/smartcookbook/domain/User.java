package lv.shebaka.smartcookbook.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

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

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : id != null) return false;
        if (username != null ? !username.equals(user.username) : username != null) return false;
        if (password != null ? !password.equals(user.password) : password != null) return false;
        return email != null ? !email.equals(user.email) : email != null;
    }
}
