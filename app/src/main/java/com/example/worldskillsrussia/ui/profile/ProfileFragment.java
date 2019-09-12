package com.example.worldskillsrussia.ui.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.worldskillsrussia.MainActivity;
import com.example.worldskillsrussia.R;
import com.example.worldskillsrussia.ui.home.Image;
import com.example.worldskillsrussia.ui.login.LoginActivity;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        DataBaseDialog dbd = new DataBaseDialog(this,((MainActivity) getActivity()).getUd() );
        if(((MainActivity) getActivity()).getUd() == null) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent, ((MainActivity) getActivity()).USER_DATA());
            return root;
        }
        Button extBtn = root.findViewById(R.id.prof_loguot);
        extBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor e = ((MainActivity) getActivity()).getSharedPreferences().edit();
                e.clear();
                e.commit();
                getActivity().getSupportFragmentManager().beginTransaction().remove(getParentFragment()).commit();
            }
        });
        ImageView view = root.findViewById(R.id.imageView2);
        view.setImageDrawable(dbd.getImage());
        TextView stat = root.findViewById(R.id.prof_status);
        stat.setText(dbd.getStatus());
        TextView name = root.findViewById(R.id.prof_fullname_res);
        name.setText(((MainActivity) getActivity()).getUd().getName());


        return root;
    }
}