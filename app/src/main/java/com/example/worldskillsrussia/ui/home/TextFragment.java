package com.example.worldskillsrussia.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;

import com.example.worldskillsrussia.R;

public class TextFragment extends Fragment {
    String text;
    public TextFragment(String text) {
        this.text = text;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_text, container, false);
        ((TextView) root.findViewById(R.id.text_content)).setText(text);
        return root;

    }

}
