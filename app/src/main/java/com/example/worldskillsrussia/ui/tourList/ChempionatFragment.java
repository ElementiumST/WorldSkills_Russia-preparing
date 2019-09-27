package com.example.worldskillsrussia.ui.tourList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.worldskillsrussia.R;
import com.example.worldskillsrussia.data.ChempionatData;
import com.example.worldskillsrussia.data.DataBaseUtils;

public class ChempionatFragment extends Fragment {

    private ChempionatData cd;

    public ChempionatFragment(int id) {
        this.cd = DataBaseUtils.getChempData(id);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_chemp, container, false);
        TextView name = root.findViewById(R.id.chemp_name);
        TextView date = root.findViewById(R.id.chemp_date);
        ImageView iv = root.findViewById(R.id.chemp_image);
        CardView cv = root.findViewById(R.id.chemp_post);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
            }
        });
        name.setText(cd.getName());
        date.setText(cd.getDate().toString());
        iv.setImageDrawable(cd.getImage());

        return root;

    }
}
