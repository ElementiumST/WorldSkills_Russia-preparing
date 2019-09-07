package com.example.worldskillsrussia.ui.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.Fragment;

import com.example.worldskillsrussia.R;

public class Image extends Fragment {
    View root;
    public Image(Drawable image) {
        setImage(image);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_post_img, container, false);
        return root;
    }
    public void setImage(Drawable image){
        ImageView iv = root.findViewById(R.id.full_post_image);
        iv.setImageDrawable(image);
    }
}
