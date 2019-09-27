package com.example.worldskillsrussia.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskillsrussia.R;
import com.example.worldskillsrussia.data.PostData;
import com.example.worldskillsrussia.data.DataBaseUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class PostActivity extends AppCompatActivity {

    private Drawable image;
    private String title;
    private List<Object> text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);


        PostData pd = DataBaseUtils.getPostData(getIntent().getExtras().getInt("id"));
        Drawable image = pd.getImage();
        String title = pd.getTitle();
        List<String> text = pd.getText();
        List<Drawable> images = pd.getImages();
        char[] order = pd.getOrder();

        FloatingActionButton fab = findViewById(R.id.share_post);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        ImageView iv = super.findViewById(R.id.full_post_image);
        iv.setImageDrawable(image);
        TextView tv = super.findViewById(R.id.full_post_title);
        tv.setText(title);
        tv.setTextColor(Color.BLACK);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv.setTextSize(24);
        if(order == null || images == null || text == null) return;
        int s = 0;
        int i = 0;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        for(char ch : order) {
            switch (ch) {
                case 's':
                    TextFragment tf = new TextFragment(text.get(s));
                    fragmentTransaction.add(R.id.full_post_main_layout, tf);
                    s++;
                    break;
                case 'i':
                    ImagesFragment imagesFragment = new ImagesFragment(images.get(i));
                    fragmentTransaction.add(R.id.full_post_main_layout, imagesFragment);
                    i++;
                    break;
            }
        }
        fragmentTransaction.commit();


    }
}
