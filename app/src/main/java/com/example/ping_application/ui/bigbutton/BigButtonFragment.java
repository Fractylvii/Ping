package com.example.ping_application.ui.bigbutton;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ping_application.MapActivityETA;
import com.example.ping_application.R;

public class BigButtonFragment extends Fragment {

    private BigButtonViewModel BigButtonViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BigButtonViewModel =
                new ViewModelProvider(this).get(BigButtonViewModel.class);
        View root = inflater.inflate(R.layout.fragment_bigbutton, container, false);

        Button map = (Button) root.findViewById(R.id.bigButtonButton);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MapActivityETA.class));
            }
        });

        return root;
    }


}