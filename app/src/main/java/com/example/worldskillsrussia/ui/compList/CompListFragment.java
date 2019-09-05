package com.example.worldskillsrussia.ui.compList;

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

public class CompListFragment extends Fragment {

    private CompListViewModel compListViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        compListViewModel =
                ViewModelProviders.of(this).get(CompListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_comp_list, container, false);

        return root;
    }
}