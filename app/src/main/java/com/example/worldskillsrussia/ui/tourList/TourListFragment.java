package com.example.worldskillsrussia.ui.tourList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.worldskillsrussia.R;

public class TourListFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tour_list, container, false);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        LinearLayout ll =  root.findViewById(R.id.chemp_list);
        for(int i = 0; i < 9; i++){
            ChempionatFragment cf = new ChempionatFragment(i);
            ft.add(ll.getId(), cf);
        }
        ft.commit();

        return root;
    }
}