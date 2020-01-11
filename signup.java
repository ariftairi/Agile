
package com.blood.donation;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blood.donation.http.SignupRequest;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity implements SignupRequest.SignupResponse {
    private TextInputEditText name, surname, location, birthdate, phonenumber, email, username, personalnumber, lastdonationdate, password, confirmpassword;
    private Spinner gender, bloodtype, donationstatus;

    private Map<String, String> params;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        location = findViewById(R.id.location);
        birthdate = findViewById(R.id.birthdate);
        phonenumber = findViewById(R.id.phonenumber);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        personalnumber = findViewById(R.id.personalnumber);
        lastdonationdate = findViewById(R.id.lastdonationdate);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmpassword);

        gender = findViewById(R.id.gender);
        bloodtype = findViewById(R.id.bloodtype);
        donationstatus = findViewById(R.id.donationstatus);

    }

    public void completeSignup(View view) {
        params = new HashMap<>();

        // Add params here
        params.put("name", name.getText().toString());
        params.put("surname", surname.getText().toString());
        params.put("location", location.getText().toString());
        params.put("birthdate", birthdate.getText().toString());
        params.put("phonenumber", phonenumber.getText().toString());
        params.put("email", email.getText().toString());
        params.put("username", username.getText().toString());
        params.put("personalnumber", personalnumber.getText().toString());
        params.put("lastdonationdate", lastdonationdate.getText().toString());
        params.put("password", password.getText().toString());
        params.put("confirmpassword", confirmpassword.getText().toString());

        params.put("gender", gender.getSelectedItem().toString());
        params.put("bloodtype", bloodtype.getSelectedItem().toString());

        String donation = donationstatus.getSelectedItem().toString();
        if (donation.equalsIgnoreCase("Donor")){
            donation = "1";
        }else {
            donation = "0";
        }

        params.put("donationstatus", donation);

        new SignupRequest(this).makeSignup(this, params);
    }

    @Override
    public void OnSuccess() {
        Toast.makeText(this, "Sign up success!", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void OnError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }
}




