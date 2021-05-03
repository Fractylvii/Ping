package com.example.ping_application.ui.contacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ping_application.R;

public class ContactsFragment extends Fragment {

    private ContactsViewModel ContactsViewModel;


    private TextView contacts;
    private String fullContacts = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContactsViewModel =
                new ViewModelProvider(this).get(ContactsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contacts, container, false);

        contacts = root.findViewById(R.id.contactsTextView);

        /*Get friendslist from database
        while(friendslist isn't empty'){
            fullContacts = friendString(fullContacts, )
        }

         */

        if(fullContacts.equals("")){
            fullContacts = "You currently have no friends.";
        }
        contacts.setText(fullContacts);

        return root;
    }

    private String friendString(String full, String name, String phoneNumber){
        return full + "Name: " + name + "\nPhone: " + phoneNumber + "\n";
    }
}