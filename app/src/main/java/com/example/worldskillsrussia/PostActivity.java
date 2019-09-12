package com.example.worldskillsrussia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.worldskillsrussia.ui.home.Image;
import com.example.worldskillsrussia.ui.home.PostData;
import com.example.worldskillsrussia.ui.home.Text;

import java.util.List;

public class PostActivity extends AppCompatActivity {

    private Drawable image;
    private String title;
    private List<Object> text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);

/*
        PostData pd =(PostData) savedInstanceState.getSerializable("postData");
        Drawable image = pd.getImage();
        String title = pd.getTitle();
        List<Object> text = pd.getText();


        ImageView iv = super.findViewById(R.id.full_post_image);
        iv.setImageDrawable(image);
        TextView tv = super.findViewById(R.id.full_post_title);
        tv.setText(title);
        LinearLayout lr = super.findViewById(R.id.full_post_main_layout);
        if(text == null) return;
        for(Object o : text) {
            if(o.getClass().equals(Drawable.class)) {
                lr.addView(new Image((Drawable) o).onCreateView(super.getLayoutInflater(), lr, savedInstanceState));

            }
            if(o.getClass().equals(String.class)) {
                lr.addView(new Text((String) o).onCreateView(super.getLayoutInflater(), lr, savedInstanceState));
            }
        }*/
    }
}
