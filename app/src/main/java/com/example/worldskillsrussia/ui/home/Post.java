package com.example.worldskillsrussia.ui.home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.worldskillsrussia.R;

import java.io.File;
import java.util.List;

public class Post extends Fragment{
    PostData pd;

    public Post(int id, Drawable img, String title, List<Object> text){
        pd = new PostData(id, img, title, text);
    }
    public Post(int id){
        pd = load(id);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_post, container, false);
        ImageButton ib = root.findViewById(R.id.goto_post_button);
        TextView tv = root.findViewById(R.id.post_title);
        ib.setImageDrawable(pd.getImage());
        ib.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("postData", pd);
                    startActivity(intent);
                }
            }
        );
        tv.setText(pd.getTitle());
        save();
        return root;
    }

    public PostData getPd() {
        return pd;
    }
    public void save(){
        File dir = new File("app//data" + String.valueOf(pd.getId()));
        if (!dir.exists())
            dir.mkdir();
        File f = new File("app//data" + String.valueOf(pd.getId()) + "");
        //TODO save system
    }
     public PostData load(int id){
         File dir = new File("app//data//" + id);
         if(!dir.exists()) {
             return null;
         } else {
            //TODO load system
         }
         return null;

     }
}
