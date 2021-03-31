package com.example.ping_application.ui.bigbutton;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ping_application.R;

public class BigButtonFragment extends Fragment {

    private BigButtonViewModel BigButtonViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BigButtonViewModel =
                new ViewModelProvider(this).get(BigButtonViewModel.class);
        View root = inflater.inflate(R.layout.fragment_bigbutton, container, false);
        return root;
    }
}