package com.example.worldskillsrussia.ui.profile;


import android.graphics.drawable.Drawable;

import androidx.fragment.app.Fragment;

import com.example.worldskillsrussia.R;
import com.example.worldskillsrussia.ui.login.UserData;

public class DataBaseDialog {
    private Fragment speaker;
    private UserData ud;

    public DataBaseDialog(Fragment speaker, UserData ud){
        this.speaker = speaker;
        this.ud = ud;
    }
    public Drawable getImage() {
        if(ud.getEmail().equals("starkov123123@gmail.com"))return speaker.getActivity().getResources().getDrawable(R.drawable.pain);
        return speaker.getActivity().getResources().getDrawable(R.drawable.protecter);
    }
    public String getStatus() {
        if(ud.getEmail().equals("starkov123123@gmail.com")) return "Android developer";
        return "common";
    }
}
