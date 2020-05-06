/*
Java Workshop 2020
First Application
06/05/2020
Moshe Weizman 305343931
Aharon Packter 201530508
 */
package com.example.myapplication.model;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Class to manage the adding and retrieving of data to the database
 */
public class FirebaseManager {

    /**
     * Static reference to the parcels database
     */
    public static DatabaseReference parcelRef;

    static {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        parcelRef = database.getReference("Parcels");
    }

    /**
     * Add the parcel to database
     * @param parcel the parcel to add
     * @return a task that adds the parcel to the database
     */
    public static Task<Void> addParcelToFirebase(final Parcel parcel) {
        return parcelRef.child(parcel.getParcelID()).setValue(parcel);
    }


}