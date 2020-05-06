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

public class FirebaseManager {

    public static DatabaseReference parcelRef;

    static {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        parcelRef = database.getReference("Parcels");
    }

    public static Task<Void> addParcelToFirebase(final Parcel parcel) {
        return parcelRef.child(parcel.getParcelID()).setValue(parcel);
    }


}