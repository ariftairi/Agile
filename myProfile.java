package com.blood.donation;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.blood.donation.controller.PreferenceHelper;
import com.blood.donation.controller.UserController;

public class MyprofileActivity extends AppCompatActivity {
    private AppCompatEditText name, surname, location, birthdate, phonenumber, email, username, personalnumber, lastdonationdate, currentpassword, password, confirmpassword;
    private Spinner bloodtype, donationstatus, gender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myprofile_activity);

//        name = findViewById(R.id.name);
//        name.setText(UserController.getUser().getDonorName());
//
//        surname = findViewById(R.id.surname);
//        surname.setText(UserController.getUser().getDonorSurname());
//
//        location = findViewById(R.id.location);
//        location.setText(UserController.getUser().getDonorLocation());
//
//        birthdate = findViewById(R.id.birthdate);
//        birthdate.setText(UserController.getUser().getDonorBirthdate());
//
//        phonenumber = findViewById(R.id.phonenumber);
//        phonenumber.setText(UserController.getUser().getDonorPhoneNumber());
//
//        email = findViewById(R.id.email);
//        email.setText(UserController.getUser().getDonorEmail());
//
//        personalnumber = findViewById(R.id.personalnumber);
//        personalnumber.setText(UserController.getUser().getDonorPersonalNo());
//
//        lastdonationdate = findViewById(R.id.lastdonationdate);
//        lastdonationdate.setText(UserController.getUser().getDonorLastDonationDate());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}