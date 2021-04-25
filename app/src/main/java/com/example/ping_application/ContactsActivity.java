package com.example.ping_application;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class ContactsActivity extends AppCompatActivity {
    public ContactsActivity(){
        super(R.layout.fragment_contacts);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("some_int", 0);

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.frameLL, AddedFragment.class, bundle)
                    .commit();
        }
    }

}
