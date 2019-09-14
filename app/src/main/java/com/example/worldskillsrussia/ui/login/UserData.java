package com.example.worldskillsrussia.ui.login;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.example.worldskillsrussia.MainActivity;
import com.example.worldskillsrussia.R;

import java.io.Serializable;

public class UserData implements Serializable {
    private int id;
    private String name;
    private String email;
    private String pass;
    private String stat;
    private Drawable image;

    public UserData(int id, String name, String email, String pass, Drawable image, String stat){
        this.id = id; //TODO auto id
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.image = image;
        this.stat = stat;// TODO for db

    }
    public static UserData createFromDatabase(String email, String pass, Resources res){
        if(!hasInDatabase(email, pass)) return  null;
        //TODO database select
        UserData ud;
        if(email.equals("admin@")) ud = new UserData(1, "STARK", email, pass, res.getDrawable(R.drawable.pain), "God");
        else ud = new UserData(1, "IMUser", email, pass, res.getDrawable(R.drawable.protecter), "developer");
        return ud;
    }
    public static boolean hasStatusInDatabase(String status){
        return true; //TODO database select
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

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Drawable getImage() {
        return image;
    }

    public String getStatus() {
        return stat;
    }

    public void setStatus(String stat) {
        this.stat = stat;
    }
}
