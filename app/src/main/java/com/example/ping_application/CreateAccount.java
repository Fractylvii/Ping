package com.example.ping_application;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class CreateAccount extends AppCompatActivity {

    private Button dateButton;
    private DatePickerDialog datePickerDialog;
    private String dateofbirth;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String driverBool;

    EditText username, password, confirmpass, fullName, phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        /*Button login = (Button) findViewById(R.id.submitButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This is where we check all the fields
                openMain();
            }
        }); */

        fullName = (EditText) findViewById(R.id.name);
        phoneNum = (EditText) findViewById(R.id.pNumber) ;
        username = (EditText) findViewById(R.id.uName) ;
        password = (EditText) findViewById(R.id.pWord) ;
        confirmpass = (EditText) findViewById(R.id.pWordConfirm);

        radioGroup = findViewById(R.id.radioGroup);

        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());

    }

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(year, month, day);
    }

    //Opens the main activity to the application
    public void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void initDatePicker()
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

    private String makeDateString(int year, int month, int dayOfMonth)
    {
        dateofbirth = year + "-" + month + "-" + dayOfMonth; //Formatted to pass to database
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

    public void birthdayPicker(View view)
    {
        datePickerDialog.show();
    }

    public void checkButton(View view)
    {
        int radioID = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);
        driverBool = null; // to have a default

        if(radioButton == findViewById(R.id.dYes))
        {
            driverBool = "TRUE";
        }
        else if(radioButton == findViewById(R.id.dNo))
        {
            driverBool = "FALSE";
        }
    }

    public void submitButton(View view)
    {
        String user = username.getText().toString(); // Turn UI values into Strings for Java
        String pass = null;
        String fname = fullName.getText().toString();
        String pnum = phoneNum.getText().toString();

        if(password.getText().toString().equals(confirmpass.getText().toString()))
        {
            pass = password.getText().toString();
        }

        userbackground bg = new userbackground(this);
        bg.execute(user, pass, fname, dateofbirth, pnum, driverBool);
    }
}