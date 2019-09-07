package com.example.worldskillsrussia.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.worldskillsrussia.R;

public class Text extends Fragment {
    View root;
    String text;
    public Text(String text){
        setText(text);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_post_text, container, false);
        return root;
    }
    public void setText(String text) {
        TextView tw = root.findViewById(R.id.fptl);
        tw.setText(text);
    }
}
