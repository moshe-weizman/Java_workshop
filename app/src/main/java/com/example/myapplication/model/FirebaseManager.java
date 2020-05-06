package com.example.myapplication.model;

import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;
import com.example.myapplication.model.Parcel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayDeque;

public class FirebaseManager {

    public static DatabaseReference parcelRef;
    public static DatabaseReference userRef;

    static {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        parcelRef = database.getReference("Parcels");
        userRef = database.getReference("users");
    }

    public static Task<Void> addParcelToFirebase(final Parcel parcel) {
        Task<Void> task = parcelRef.child(parcel.getParcelID()).setValue(parcel);
        return task;
    }


}