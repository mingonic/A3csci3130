package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText BusNumField, NamField, PBusField, AddField, ProvField;
    Contact receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        BusNumField = (EditText) findViewById(R.id.businessnumber);
        NamField = (EditText) findViewById(R.id.name);
        PBusField = (EditText) findViewById(R.id.pbusiness);
        AddField = (EditText) findViewById(R.id.address);
        ProvField = (EditText) findViewById(R.id.provence);

        if(receivedPersonInfo != null){
            BusNumField = (EditText) findViewById(R.id.businessnumber);
            NamField = (EditText) findViewById(R.id.name);
            PBusField = (EditText) findViewById(R.id.pbusiness);
            AddField = (EditText) findViewById(R.id.address);
            ProvField = (EditText) findViewById(R.id.provence);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality

    }
}
