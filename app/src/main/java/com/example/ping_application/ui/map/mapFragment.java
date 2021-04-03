package com.example.ping_application.ui.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ping_application.MapActivity;
import com.example.ping_application.R;

public class mapFragment extends Fragment {


    private mapViewModel MapViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MapViewModel =
                new ViewModelProvider(this).get(mapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_map, container, false);

        Button map = (Button) root.findViewById(R.id.mapButton);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MapActivity.class));
            }
        });

        return root;
    }
}