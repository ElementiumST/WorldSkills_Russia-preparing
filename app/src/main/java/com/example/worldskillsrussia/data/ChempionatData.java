package com.example.worldskillsrussia.data;

import android.graphics.drawable.Drawable;

import java.util.Date;

public class ChempionatData {
    private int id;
    private String name;
    private Date date;
    private Drawable image;

    public ChempionatData(int id, String name, Date date, Drawable image) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
