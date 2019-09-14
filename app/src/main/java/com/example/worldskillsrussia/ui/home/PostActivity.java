package com.example.worldskillsrussia.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.worldskillsrussia.R;

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


        PostData pd =(PostData) savedInstanceState.getSerializable("postData");
        Drawable image = pd.getImage();
        String title = pd.getTitle();
        List<String> text = pd.getText();
        List<Drawable> images = pd.getImages();
        char[] order = pd.getOrder();

        ImageView iv = super.findViewById(R.id.full_post_image);
        iv.setImageDrawable(image);
        TextView tv = super.findViewById(R.id.full_post_title);
        tv.setText(title);
        LinearLayout lr = super.findViewById(R.id.full_post_main_layout);
        if(order == null || images == null || text == null) return;
        int s = 0;
        int i = 0;
        for(char ch : order) {
            switch (ch) {
                case 's':
                    TextFragment tf = new TextFragment();
                    tf.setText(text.get(s));
                    lr.addView(tf.onCreateView(getLayoutInflater(), lr, savedInstanceState));
                    s++;
                    break;
                case 'i':
                    ImagesFragment imagesFragment = new ImagesFragment();
                    imagesFragment.setImage(images.get(i));
                    lr.addView(imagesFragment.onCreateView(getLayoutInflater(), lr, savedInstanceState));
                    i++;
                    break;
            }
        }
    }
}
