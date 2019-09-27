package com.example.worldskillsrussia.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.worldskillsrussia.R;
import com.example.worldskillsrussia.data.PostData;
import com.example.worldskillsrussia.data.DataBaseUtils;

public class PostFragment extends Fragment {
    private int ID;
    PostData pd;

    public PostFragment(int ID) {
        this.ID = ID;
        pd = DataBaseUtils.getPostData(ID);
    }



    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_post, container, false);
        TextView tv = root.findViewById(R.id.post_title);
        ImageView iv = root.findViewById(R.id.post_image);
        tv.setText(pd.getTitle());
        iv.setImageDrawable(pd.getImage());
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PostActivity.class);
                intent.putExtra("id", ID);
                startActivity(intent);
            }
        });
        return root;
    }
}
