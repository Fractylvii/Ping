package com.example.ping_application.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ping_application.R;

public class settingsFragment extends Fragment {

    private settingsViewModel SettingsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingsViewModel =
                new ViewModelProvider(this).get(settingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        //This is where you would change the text
        TextView name = (TextView) root.findViewById(R.id.AccountName);
        TextView birthday = (TextView) root.findViewById(R.id.AccountBirthday);
        TextView phone = (TextView) root.findViewById(R.id.AccountPhoneNumber);
        TextView driver = (TextView) root.findViewById(R.id.AccountDriver);

        //Update from database here :)
        name.setText("TESTING");
        birthday.setText("01/01/1969");
        phone.setText("806-420-6969");
        driver.setText("No");

        return root;
    }

}