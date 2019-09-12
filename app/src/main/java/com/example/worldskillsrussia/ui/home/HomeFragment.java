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

        Post post0 = new Post(1, getActivity().getResources().getDrawable(R.drawable.one), "one", null);
        Post post1 = new Post(2, getActivity().getResources().getDrawable(R.drawable.two), "two", null);
        Post post2 = new Post(3, getActivity().getResources().getDrawable(R.drawable.three), "three", null);
        Post post3 = new Post(4, getActivity().getResources().getDrawable(R.drawable.four), "four", null);
        Post post4 = new Post(5, getActivity().getResources().getDrawable(R.drawable.wsr_logo), "WSR", null);
        l.addView(post0.onCreateView(inflater, container, savedInstanceState));
        l.addView(post1.onCreateView(inflater, container, savedInstanceState));
        l.addView(post2.onCreateView(inflater, container, savedInstanceState));
        l.addView(post3.onCreateView(inflater, container, savedInstanceState));
        l.addView(post4.onCreateView(inflater, container, savedInstanceState));

        return root;
    }

}