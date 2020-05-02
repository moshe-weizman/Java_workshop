package com.example.myapplication;
import com.example.myapplication.model.Parcel;
import com.example.myapplication.model.ParcelType;
import com.example.myapplication.model.Person;
import com.example.myapplication.model.WeightParcel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    Parcel parcel=new Parcel();
    Person person=new Person();
    RadioButton radioButtonEnvelop, radioButtonSmallParcel,radioButtonBigParcel,radioButtonUpTo500,radioButtonUpTo1, radioButtonUpTo5, radioButtonUpTo20;
    Button buttonSubmitParcel, buttonAddAnthorParcel, buttonClear;
    EditText editTextPhone, editTextAddress, editTextFirstName,editTextLastName,  editTextEmail;
    ParcelType type;
    WeightParcel weight;

    public void onRadioButtonClickedType(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButtonEnvelop:
                if (checked)
                    parcel.set_type(type.ENVELOPE);
                    break;
            case R.id.radioButtonSmallParcel:
                if (checked)
                    parcel.set_type(type.SMALL_PARCEL);
                break;
            case R.id.radioButtonBigParcel:
                if (checked)
                    parcel.set_type(type.BIG_PARCEL);
                break;

        }
    }

    public void onRadioButtonClickedWeight(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButtonUpTo500:
                if (checked)
                    parcel.set_weight(weight.UP_TO_500G);
                break;
            case R.id.radioButtonUpTo1:
                if (checked)
                    parcel.set_weight(weight.UP_TO_1KG);
                break;
            case R.id.radioButtonUpTo5:
                if (checked)
                    parcel.set_weight(weight.UP_TO_5KG);
                break;
            case R.id.radioButtonUpTo20:
                if (checked)
                    parcel.set_weight(weight.UP_TO_20KG);
                break;
        }
    }
    public void onCheckboxClicked(View view) {
            parcel.set_fragile(((CheckBox) view).isChecked());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonAddAnthorParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                buttonSubmitParcel.setEnabled(true);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                buttonSubmitParcel.setEnabled(true);
            }
        });

        buttonSubmitParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                person.set_firstName(editTextFirstName.getText().toString());
                person.set_lastName(editTextLastName.getText().toString());
                person.set_phone(editTextPhone.getText().toString());
                person.set_address(editTextAddress.getText().toString());
                person.set_email(editTextEmail.getText().toString());
                parcel.set_person(person);

                DatabaseReference myRef = database.getReference("Parcels");
                String key = myRef.push().getKey();
                myRef.child(key).push().setValue(parcel);

                buttonSubmitParcel.setEnabled(false);

            }
        });

    }

    private void init() {
        radioButtonSmallParcel=findViewById(R.id.radioButtonSmallParcel);
        radioButtonBigParcel=findViewById(R.id.radioButtonBigParcel);
        radioButtonUpTo500=findViewById(R.id.radioButtonUpTo500);
        radioButtonUpTo1=findViewById(R.id.radioButtonUpTo1);
        radioButtonUpTo5=findViewById(R.id.radioButtonUpTo5);
        radioButtonUpTo20=findViewById(R.id.radioButtonUpTo20);
        radioButtonEnvelop=findViewById(R.id.radioButtonEnvelop);
        buttonSubmitParcel = findViewById(R.id.buttonSubmitParcel);
        buttonAddAnthorParcel=findViewById(R.id.buttonAddAnthorParcel);
        buttonClear=findViewById(R.id.buttonClear);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextLastName= findViewById(R.id.editTextLastName);
    }

    private void clear() {
        editTextFirstName.setText("");
        editTextLastName.setText("");
        editTextPhone.setText("");
        editTextAddress.setText("");
        editTextEmail.setText("");
        radioButtonEnvelop.setChecked(false);
        radioButtonSmallParcel.setChecked(false);
        radioButtonBigParcel.setChecked(false);
        radioButtonUpTo500.setChecked(false);
        radioButtonUpTo1.setChecked(false);
        radioButtonUpTo5.setChecked(false);
        radioButtonUpTo20.setChecked(false);
    }
}
