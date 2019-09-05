package com.example.worldskillsrussia.ui.tourList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.worldskillsrussia.R;

public class TourListFragment extends Fragment {

    private TourListViewModel tourListViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tourListViewModel =
                ViewModelProviders.of(this).get(TourListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tour_list, container, false);

        return root;
    }
}