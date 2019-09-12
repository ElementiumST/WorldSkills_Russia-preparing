package com.example.worldskillsrussia.ui.login;

import java.io.Serializable;

public class UserData implements Serializable {
    private int id;
    private String name;
    private String email;
    private String pass;

    public UserData(int id, String name, String email, String pass){
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;

    }
    public static UserData createFromDatabase(String email, String pass){
        if(!hasInDatabase(email, pass)) return  null;
        //TODO database select
        UserData ud = new UserData(1, "IMUser", email, pass);
        return ud;
    }

    public static boolean hasInDatabase(String email, String pass) {
        //TODO database select

        return true;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
