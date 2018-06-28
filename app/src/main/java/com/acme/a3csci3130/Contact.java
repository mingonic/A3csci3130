package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  String uid;
    public  String name;
    public  String pbusiness;
    public  String bnumber;
    public  String address;
    public  String provence;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String name, String bnumber, String pbusiness, String address, String provence){
        this.uid = uid;
        this.name = name;
        this.pbusiness = pbusiness;
        this.bnumber = bnumber;
        this.address = address;
        this.provence = provence;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("pbusiness", pbusiness);
        result.put("bnumber", bnumber);
        result.put("address", address);
        result.put("provence", provence);

        return result;
    }
}
