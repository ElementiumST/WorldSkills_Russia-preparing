package com.example.worldskillsrussia.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.worldskillsrussia.MainActivity;
import com.example.worldskillsrussia.R;

public class PostView extends Fragment {
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, int id) {
        View root = inflater.inflate(R.layout.fragment_post, container);
        PostData pd = PostData.getPostData((MainActivity) getActivity() ,id);
        TextView tv = root.findViewById(R.id.post_title);
        ImageView iv = root.findViewById(R.id.post_image);
        tv.setText(pd.getTitle());
        iv.setImageDrawable(pd.getImage());
        return root;
    }
}
