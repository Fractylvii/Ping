package com.example.ping_application;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
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
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private CurrentUser currentUser;

    private DatePickerDialog datePickerDialog;
    private String dateofbirth;
    private String driverBool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_settings);
        //TextView name = (TextView) findViewById(R.id.AccountName);
        //name.setText("Testing");
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

        TextView accName = findViewById(R.id.AccountName);
        TextView accBirth = findViewById(R.id.AccountBirthday);
        TextView accPhone = findViewById(R.id.AccountPhoneNumber);
        TextView accDriver = findViewById(R.id.AccountDriver);
        EditText fullEdit = findViewById(R.id.nameInput);
        Button birthEdit = findViewById(R.id.birthdayInput);
        EditText phoneEdit = findViewById(R.id.phoneInput);
        RadioButton driveYes = findViewById(R.id.dYes1);
        RadioButton driveNo = findViewById(R.id.dNo2);

        initDatePicker(birthEdit);

        fullEdit.setText(accName.getText()); // Converts non-editable lines to editable lines
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

        TextView accName = findViewById(R.id.AccountName);
        TextView accBirth = findViewById(R.id.AccountBirthday);
        TextView accPhone = findViewById(R.id.AccountPhoneNumber);
        TextView accDriver = findViewById(R.id.AccountDriver);
        EditText fullEdit = findViewById(R.id.nameInput);
        Button birthEdit = findViewById(R.id.birthdayInput);
        EditText phoneEdit = findViewById(R.id.phoneInput);
        RadioGroup driveEdit = findViewById(R.id.driverInput);

        int selectedRadioButtonId = driveEdit.getCheckedRadioButtonId();

        String uFull = fullEdit.getText().toString(); //Sends update to mySQL
        String uPhone = phoneEdit.getText().toString();
        updatebackground bg = new updatebackground(this);
        bg.execute(uFull, dateofbirth, uPhone, driverBool, currentUser.getFullName(), currentUser.getPhoneNum());

        currentUser.setFullName(uFull); //Updates Current User
        currentUser.setBirthday(dateofbirth);
        currentUser.setPhoneNum(uPhone);
        currentUser.setDriverBool(driverBool);

        accName.setText(fullEdit.getText()); //Converts editable lines to non-editable
        accBirth.setText(birthEdit.getText());
        accPhone.setText(phoneEdit.getText());
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String selectedRbText = selectedRadioButton.getText().toString();
        accDriver.setText(selectedRbText);

        ViewGroup.MarginLayoutParams params2 = (ViewGroup.MarginLayoutParams) findViewById(R.id.AccountName).getLayoutParams();
        params2.topMargin = 120;
        findViewById(R.id.AccountName).setLayoutParams(params2);
    }

    private String makeDateString(int year, int month, int dayOfMonth) // Turns date slider into String for display
    {
        dateofbirth = year + "-" + month + "-" + dayOfMonth; //Formatted to pass to database
        String birthStr = getDateString(dateofbirth);
        return birthStr;
    }

    private static String getDateString(String sqlDate) // Turns mySQL DATE into written String
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

    public CurrentUser passUser() { //Passes user object to other classes or fragments
        return currentUser;
    }

    public void birthdayPicker(View view)
    {
        datePickerDialog.show();
    }

    private void initDatePicker(Button dateButton)
    {

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String birthday = makeDateString(year, month, dayOfMonth);
                dateButton.setText(birthday);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    }

    public void checkButton(View view) // Turns RadioButton into String for mySQL
    {
        RadioGroup driveEdit = findViewById(R.id.driverInput);

        int radioID = driveEdit.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioID);
        driverBool = null; // to have a default

        if(radioButton == findViewById(R.id.dYes1))
        {
            driverBool = "TRUE";
        }
        else if(radioButton == findViewById(R.id.dNo2))
        {
            driverBool = "FALSE";
        }
    }

}