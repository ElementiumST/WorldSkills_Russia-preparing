package com.example.worldskillsrussia.data;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import com.example.worldskillsrussia.MainActivity;
import com.example.worldskillsrussia.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UserData implements Serializable {

    private String email;
    private String name;
    private String pass;
    private String stat;
    private Bitmap image;
    public UserData () {}
    public UserData(String name, String email, String pass, String stat) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.stat = stat;
    }
    public UserData(String name, String email, String pass, Bitmap image, String stat){
        this.name = name;
        this.email = email;
        this.pass = pass;
        if(image != null)
            this.image = image;
        else
            this.image = BitmapFactory.decodeResource(MainActivity.getRes(), R.drawable.protecter);
        this.stat = stat;// TODO for db

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

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getStatus() {
        return stat;
    }

    public void setStatus(String stat) {
        this.stat = stat;
    }

    public void setUserdata(UserData ud) {
        this.email = ud.email;
        this.image = ud.image;
        this.name = ud.name;
        this.pass = ud.pass;
        this.stat = ud.stat;
    }
}
