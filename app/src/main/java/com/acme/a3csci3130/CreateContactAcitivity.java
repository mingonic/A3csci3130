package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText BusNumField, NamField, PBusField, AddField, ProvField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        BusNumField = (EditText) findViewById(R.id.businessnumber);
        NamField = (EditText) findViewById(R.id.name);
        PBusField = (EditText) findViewById(R.id.pbusiness);
        AddField = (EditText) findViewById(R.id.address);
        ProvField = (EditText) findViewById(R.id.provence);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = NamField.getText().toString();
        String bnumber = BusNumField.getText().toString();
        String pbusiness = PBusField.getText().toString();
        String address = AddField.getText().toString();
        String provence = ProvField.getText().toString();

        Contact person = new Contact(personID, name, bnumber, pbusiness, address, provence);

        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
