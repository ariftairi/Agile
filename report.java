package com.blood.donation;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blood.donation.controller.UserController;
import com.blood.donation.http.ReportRequest;

import java.util.HashMap;
import java.util.Map;

public class ReportActivity extends AppCompatActivity implements ReportRequest.ReportResponse {
    private Spinner hospitalname, bloodtype, hospitallocation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_activity);

        hospitalname = findViewById(R.id.hospitalname);
        bloodtype = findViewById(R.id.bloodtype);
        hospitallocation = findViewById(R.id.hospitallocation);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }

    public void doReport(View view) {
        if (UserController.getUser() == null){
            Toast.makeText(this, "You lost your user data. You need to login again!", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, String> params = new HashMap<>();

        params.put("reportername", UserController.getUser().getDonorName() + " " + UserController.getUser().getDonorSurname());
        params.put("reportercontact", UserController.getUser().getDonorPhoneNumber());

        params.put("hospitalname", hospitalname.getSelectedItem().toString());
        params.put("bloodtype", bloodtype.getSelectedItem().toString());
        params.put("hospitallocation", hospitallocation.getSelectedItem().toString());


        new ReportRequest(this).makeReport(this, params);
    }

    @Override
    public void OnSuccess() {
        Toast.makeText(this, "Successful reported!", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void OnError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}