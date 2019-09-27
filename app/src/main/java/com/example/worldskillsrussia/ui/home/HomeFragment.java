package com.example.worldskillsrussia.ui.home;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.worldskillsrussia.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {
    private int i = 0;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        loadPosts();

        root = inflater.inflate(R.layout.fragment_home, container, false);
        FloatingActionButton fab1 = root.findViewById(R.id.fab);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FloatingActionButton fab = root.findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "Обновление новостей...", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
            }
        });
        FloatingActionButton fab2 = root.findViewById(R.id.more_news_fab);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPosts();
            }
        });

        //тестовый блок, потом удалить
        //===========================

        //===========================

        return root;
    }



    public void loadPosts() {
        //создание виджетов новостей


        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        for(int a = 0; a < 5; i++, a++){
            fragmentTransaction.add(R.id.news_layout, new PostFragment(i));
        }
        fragmentTransaction.commit();// завершение создания новостей


    }


}