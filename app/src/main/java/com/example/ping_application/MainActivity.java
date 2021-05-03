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

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;



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

        TextView text1 = findViewById(R.id.AccountName);
        TextView text2 = findViewById(R.id.AccountBirthday);
        TextView text3 = findViewById(R.id.AccountPhoneNumber);
        TextView text4 = findViewById(R.id.AccountDriver);
        EditText text5 = findViewById(R.id.nameInput);
        EditText text6 = findViewById(R.id.birthdayInput);
        EditText text7 = findViewById(R.id.phoneInput);
        RadioButton text8 = findViewById(R.id.dYes1);
        RadioButton text9 = findViewById(R.id.dNo2);



        text5.setText(text1.getText());
        text6.setText(text2.getText());
        text7.setText(text3.getText());
        if(text4.getText().equals("No")){
            text9.setChecked(true);
        }
        else{
            text8.setChecked(true);
        }

        ViewGroup.MarginLayoutParams params2 = (ViewGroup.MarginLayoutParams) findViewById(R.id.AccountName).getLayoutParams();
        params2.topMargin = 5000;
        findViewById(R.id.AccountName).setLayoutParams(params2);
    }

    public void confirmButton(View view){
        ViewGroup.MarginLayoutParams params1 = (ViewGroup.MarginLayoutParams) findViewById(R.id.nameInput).getLayoutParams();
        params1.topMargin = 5000;
        findViewById(R.id.nameInput).setLayoutParams(params1);

        TextView text1 = findViewById(R.id.AccountName);
        TextView text2 = findViewById(R.id.AccountBirthday);
        TextView text3 = findViewById(R.id.AccountPhoneNumber);
        TextView text4 = findViewById(R.id.AccountDriver);
        EditText text5 = findViewById(R.id.nameInput);
        EditText text6 = findViewById(R.id.birthdayInput);
        EditText text7 = findViewById(R.id.phoneInput);
        RadioGroup text8 = findViewById(R.id.driverInput);
        int selectedRadioButtonId = text8.getCheckedRadioButtonId();

        text1.setText(text5.getText());
        text2.setText(text6.getText());
        text3.setText(text7.getText());
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String selectedRbText = selectedRadioButton.getText().toString();
        text4.setText(selectedRbText);


        ViewGroup.MarginLayoutParams params2 = (ViewGroup.MarginLayoutParams) findViewById(R.id.AccountName).getLayoutParams();
        params2.topMargin = 120;
        findViewById(R.id.AccountName).setLayoutParams(params2);
    }
}