package com.example.worldskillsrussia.ui.home;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import com.example.worldskillsrussia.MainActivity;
import com.example.worldskillsrussia.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PostData implements Serializable {
    private int id;
    private Drawable img;
    private String title;
    private List<String> text;
    private List<Drawable> images;
    private char[] order;

    public PostData(int id, Drawable image, String title, List<String> text, List<Drawable> images, char[] order) {
        this.id = id;
        this.img = image;
        this.title = title;
        this.text = text;
        this.images = images;
        this.order = order;
    }
    public static PostData getPostData(MainActivity sender, int id) {
        //TODO load system
        //TODO load from database system
        List<String> text = new ArrayList<String>();
        text.add("asdsadfsdfasdcaefasdf");
        text.add("TESTESTESTEST!");
        List<Drawable> images = new ArrayList<Drawable>();
        images.add(sender.getResources().getDrawable(R.drawable.three));
        char[] order = new char[] {'s', 'i', 's'};

        return new PostData(id, sender.getResources().getDrawable(R.drawable.wsr_logo), String.valueOf(id), text, images, order);

    }
    public Drawable getImage() {
        return  img;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getText() {
        return text;
    }

    public void setImage(Drawable img) {
        this.img = img;
    }

    public void setText(List<String> text) {
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

    public char[] getOrder() {
        return order;
    }

    public void setOrder(char[] order) {
        this.order = order;
    }

    public List<Drawable> getImages() {
        return images;
    }

    public void setImages(List<Drawable> images) {
        this.images = images;
    }
}
