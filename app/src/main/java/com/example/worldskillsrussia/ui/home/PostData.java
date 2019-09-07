package com.example.worldskillsrussia.ui.home;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.List;

public class PostData implements Serializable {
    private int id;
    private Drawable img;
    private String title;
    private List<Object> text;

    public PostData(int id, Drawable image, String title, List<Object> text) {
        this.id = id;
        this.img = image;
        this.title = title;
        this.text = text;
    }
    public Drawable getImage() {
        return  img;
    }

    public String getTitle() {
        return title;
    }

    public List<Object> getText() {
        return text;
    }

    public void setImage(Drawable img) {
        this.img = img;
    }

    public void setText(List<Object> text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
