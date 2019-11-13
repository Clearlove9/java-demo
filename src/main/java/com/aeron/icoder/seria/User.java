package com.aeron.icoder.seria;

import java.io.Serializable;

public class User extends Farther implements Serializable {
    private static final long serialVersionUID = -6955559744939203850L;

    private String username;

    private transient String password;

    private String id;

    public User(String a) {
        super(a);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String a, String username, String password, String id) {
        super(a);
        this.username = username;
        this.password = password;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
