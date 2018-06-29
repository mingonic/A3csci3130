package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * This class displays the objects and is the main funcality of this assignment
 */
public class DetailViewActivity extends Activity {

    private EditText BusNumField, NamField, PBusField, AddField, ProvField;
    private MyApplicationData Status;
    Contact receivedPersonInfo;

    /**
     * This method creats the sessions in the database
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Status = ((MyApplicationData) getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        BusNumField = (EditText) findViewById(R.id.businessnumber);
        NamField = (EditText) findViewById(R.id.name);
        PBusField = (EditText) findViewById(R.id.pbusiness);
        AddField = (EditText) findViewById(R.id.address);
        ProvField = (EditText) findViewById(R.id.provence);

        if(receivedPersonInfo != null){
            BusNumField.setText(receivedPersonInfo.bnumber);
            NamField.setText(receivedPersonInfo.name);
            PBusField.setText(receivedPersonInfo.pbusiness);
            AddField.setText(receivedPersonInfo.address);
            ProvField.setText(receivedPersonInfo.provence);
        }

    }


    /**
     * This method is updating the contect of firebase
     * @param v
     */
    public void updateContact(View v) {
        Status = ((MyApplicationData) getApplicationContext());
        String personID = receivedPersonInfo.uid;
        String name = NamField.getText().toString();
        String address = AddField.getText().toString();
        String business_number = BusNumField.getText().toString();
        String primary_business = PBusField.getText().toString();
        String provence = ProvField.getText().toString();

        Contact updatePersonInfo = new Contact(personID, name, business_number, primary_business, address, provence);

        Status.firebaseReference.child(personID).setValue(updatePersonInfo);

        finish();
    }


    /**
     * This method is deleting a entry in firebase
     * @param v
     */
    public void eraseContact(View v)
    {
        Status = ((MyApplicationData) getApplicationContext());
        String personID = receivedPersonInfo.uid;
        Status.firebaseReference.child(personID).removeValue();

        finish();
    }
}
