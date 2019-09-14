package com.example.worldskillsrussia.ui.home;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.worldskillsrussia.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout l = root.findViewById(R.id.news_layout);
        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Обновление новостей...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //тестовый блок, потом удалить
        //===========================
        PostView pv1 = new PostView();
        pv1.onCreateView(inflater, l, 1);
        PostView pv2 = new PostView();
        pv1.onCreateView(inflater, l, 2);
        PostView pv3 = new PostView();
        pv1.onCreateView(inflater, l, 3);
        PostView pv4 = new PostView();
        pv1.onCreateView(inflater, l, 4);
        PostView pv5 = new PostView();
        pv1.onCreateView(inflater, l, 5);
        PostView pv6 = new PostView();
        pv1.onCreateView(inflater, l, 6);
        PostView pv7 = new PostView();
        pv1.onCreateView(inflater, l, 7);
        PostView pv8 = new PostView();
        pv1.onCreateView(inflater, l, 8);
        PostView pv9 = new PostView();
        pv1.onCreateView(inflater, l, 9);
        //===========================

        return root;
    }

}