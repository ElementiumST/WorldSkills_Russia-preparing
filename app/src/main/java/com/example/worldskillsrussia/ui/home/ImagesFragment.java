package com.example.worldskillsrussia.ui.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import android.widget.ImageView;
import com.example.worldskillsrussia.R;

public class ImagesFragment extends Fragment {
    Drawable image;

    public ImagesFragment(Drawable image){
        this.image = image;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_images, container, false);
        ((ImageView) root.findViewById(R.id.image_content)).setImageDrawable(image);
        return root;
    }

}
