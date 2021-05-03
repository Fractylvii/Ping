package com.example.ping_application.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ping_application.CurrentUser;
import com.example.ping_application.MainActivity;
import com.example.ping_application.R;

public class settingsFragment extends Fragment {

    private settingsViewModel SettingsViewModel;
    private CurrentUser currentUser;

    TextView accName;
    TextView accBirth;
    TextView accPhone;
    TextView accDriver;
    EditText fullEdit;
    Button birthEdit;
    EditText phoneEdit;
    RadioGroup driveEdit;
    RadioButton driveYes;
    RadioButton driveNo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingsViewModel =
                new ViewModelProvider(this).get(settingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        //This is where you would change the text
        //TextView name = (TextView) root.findViewById(R.id.AccountName);
        //TextView birthday = (TextView) root.findViewById(R.id.AccountBirthday);
        //TextView phone = (TextView) root.findViewById(R.id.AccountPhoneNumber);
        //TextView driver = (TextView) root.findViewById(R.id.AccountDriver);

        MainActivity activity = (MainActivity) getActivity();
        currentUser = activity.passUser();

        accName = root.findViewById(R.id.AccountName);
        accBirth = root.findViewById(R.id.AccountBirthday);
        accPhone = root.findViewById(R.id.AccountPhoneNumber);
        accDriver = root.findViewById(R.id.AccountDriver);
        fullEdit = root.findViewById(R.id.nameInput);
        birthEdit = root.findViewById(R.id.birthdayInput);
        phoneEdit = root.findViewById(R.id.phoneInput);
        driveEdit = root.findViewById(R.id.driverInput);
        driveYes = root.findViewById(R.id.dYes1);
        driveNo = root.findViewById(R.id.dNo2);

        accName.setText(currentUser.getFullName());
        accBirth.setText(getDateString(currentUser.getBirthday()));
        accPhone.setText(currentUser.getPhoneNum());
        if(currentUser.getDriverBool().equals("TRUE")) {
            accDriver.setText("Yes");
        }
        else {
            accDriver.setText("No");
        }

        return root;
    }
    private String makeDateString(int year, int month, int dayOfMonth)
    {
        String dateofbirth = year + "-" + month + "-" + dayOfMonth; //Formatted to pass to database
        String birthStr = getDateString(dateofbirth);
        return birthStr;
    }

    private static String getDateString(String sqlDate)
    {
        String[] dateParts = sqlDate.split("-");
        String year = dateParts[0];
        int month = Integer.parseInt(dateParts[1]);
        String dayOfMonth = dateParts[2];
        String monthstr = "";

        switch(month)
        {
            case 1:
                monthstr = "January";
                break;
            case 2:
                monthstr = "February";
                break;
            case 3:
                monthstr = "March";
                break;
            case 4:
                monthstr = "April";
                break;
            case 5:
                monthstr = "May";
                break;
            case 6:
                monthstr = "June";
                break;
            case 7:
                monthstr = "July";
                break;
            case 8:
                monthstr = "August";
                break;
            case 9:
                monthstr = "September";
                break;
            case 10:
                monthstr = "October";
                break;
            case 11:
                monthstr = "November";
                break;
            case 12:
                monthstr = "December";
                break;
            default:
                break;
        }
        return monthstr + " " + dayOfMonth + ", " + year;
    }
}