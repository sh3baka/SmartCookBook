package lv.shebaka.smartcookbook.domain.builders;


import lv.shebaka.smartcookbook.domain.User;

public class UserBuilder {

    private Long id;
    private String username;
    private String password;

    private UserBuilder(){}

    public static UserBuilder createUser(){return new UserBuilder();}

    public User build(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    public UserBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public UserBuilder withUsername(String username){
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password){
        this.password = password;
        return this;
    }
}
