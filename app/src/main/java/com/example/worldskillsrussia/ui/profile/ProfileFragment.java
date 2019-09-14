package com.example.worldskillsrussia.ui.profile;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
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
import com.example.worldskillsrussia.ui.login.UserData;

public class ProfileFragment extends Fragment {
    private boolean onLog = false;
    View root;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_profile, container, false);
        if(!((MainActivity) getActivity()).isAuth()) {
            ((MainActivity) getActivity()).startLoginActivity();
            onLog = true;
            return root;
        }
        loadData();


        return root;
    }

    @Override
    public void onResume() {
        if(!onLog){
            loadData();
        }
        onLog = false;
        super.onResume();

    }
    private void loadData(){
        Button extBtn = root.findViewById(R.id.prof_loguot);
        extBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity) getActivity()).setAuth(false);
                Intent mStartActivity = new Intent(getContext(), MainActivity.class);
                int mPendingIntentId = 123456;
                PendingIntent mPendingIntent = PendingIntent.getActivity(getContext(), mPendingIntentId,    mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager mgr = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
                mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
                System.exit(0);
            }
        });
        UserData ud = ((MainActivity) getActivity()).getUd();
        ImageView view = root.findViewById(R.id.imageView2);
        view.setImageDrawable(ud.getImage());
        TextView stat = root.findViewById(R.id.prof_status);
        stat.setText(ud.getStatus());
        TextView name = root.findViewById(R.id.prof_fullname_res);
        name.setText(((MainActivity) getActivity()).getUd().getName());
    }
}