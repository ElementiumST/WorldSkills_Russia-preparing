package com.example.worldskillsrussia.data;

import android.graphics.drawable.Drawable;

import com.example.worldskillsrussia.MainActivity;
import com.example.worldskillsrussia.R;
import com.example.worldskillsrussia.data.PostData;
import com.example.worldskillsrussia.data.ChempionatData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBaseUtils {
    public static PostData getPostData(int id) {
        //TODO load system
        //TODO load from database system
        List<String> text = new ArrayList<String>();
        text.add("asdsadfsdfasdcaefasdf");
        text.add("TESTESTESTEST!");
        List<Drawable> images = new ArrayList<Drawable>();
        images.add(MainActivity.getRes().getDrawable(R.drawable.three));
        char[] order = new char[] {'s', 'i', 's'};

        return new PostData(id, MainActivity.getRes().getDrawable(R.drawable.wsr_logo), String.valueOf(id), text, images, order);

    }
    public static ChempionatData getChempData(int id) {
        Drawable image = MainActivity.getRes().getDrawable(R.drawable.protecter);
        return new ChempionatData(id, "Чемпионат "+id, new Date(), image);
    }
   // public static
}
