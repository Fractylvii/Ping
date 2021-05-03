package com.example.ping_application;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private CurrentUser currentUser;

    TextView accName;
    TextView accBirth;
    TextView accPhone;
    TextView accDriver;
    EditText fullEdit;
    EditText birthEdit;
    EditText phoneEdit;
    RadioGroup driveEdit;
    RadioButton driveYes;
    RadioButton driveNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_settings);
        TextView name = (TextView) findViewById(R.id.AccountName);
        name.setText("Testing");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_bigButton, R.id.nav_contacts, R.id.nav_settings, R.id.nav_map)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        currentUser = getIntent().getExtras().getParcelable("currUser");

       /* accName = findViewById(R.id.AccountName);
        accBirth = findViewById(R.id.AccountBirthday);
        accPhone = findViewById(R.id.AccountPhoneNumber);
        accDriver = findViewById(R.id.AccountDriver);
        fullEdit = findViewById(R.id.nameInput);
        birthEdit = findViewById(R.id.birthdayInput);
        phoneEdit = findViewById(R.id.phoneInput);
        driveEdit = findViewById(R.id.driverInput);
        driveYes = findViewById(R.id.dYes1);
        driveNo = findViewById(R.id.dNo2);

        currentUser.printAllInfo();

        accName.setText(currentUser.getFullName());
        accBirth.setText(getDateString(currentUser.getBirthday()));
        accPhone.setText(currentUser.getPhoneNum());
        if(currentUser.getDriverBool().equals("TRUE")) {
            accDriver.setText("Yes");
        }
        else {
            accDriver.setText("No");
        } */
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void editAccount(View view){
        ViewGroup.MarginLayoutParams params1 = (ViewGroup.MarginLayoutParams) findViewById(R.id.nameInput).getLayoutParams();
        params1.topMargin = 50;
        findViewById(R.id.nameInput).setLayoutParams(params1);

        fullEdit.setText(accName.getText());
        birthEdit.setText(accBirth.getText());
        phoneEdit.setText(accPhone.getText());
        if(accDriver.getText().equals("No")) {
            driveNo.setChecked(true);
        }
        else {
            driveYes.setChecked(true);
        }

        ViewGroup.MarginLayoutParams params2 = (ViewGroup.MarginLayoutParams) findViewById(R.id.AccountName).getLayoutParams();
        params2.topMargin = 5000;
        findViewById(R.id.AccountName).setLayoutParams(params2);
    }

    public void confirmButton(View view){
        ViewGroup.MarginLayoutParams params1 = (ViewGroup.MarginLayoutParams) findViewById(R.id.nameInput).getLayoutParams();
        params1.topMargin = 5000;
        findViewById(R.id.nameInput).setLayoutParams(params1);

        int selectedRadioButtonId = driveEdit.getCheckedRadioButtonId();

        accName.setText(fullEdit.getText());
        accBirth.setText(birthEdit.getText());
        accPhone.setText(phoneEdit.getText());
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String selectedRbText = selectedRadioButton.getText().toString();
        accDriver.setText(selectedRbText);

        ViewGroup.MarginLayoutParams params2 = (ViewGroup.MarginLayoutParams) findViewById(R.id.AccountName).getLayoutParams();
        params2.topMargin = 120;
        findViewById(R.id.AccountName).setLayoutParams(params2);
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