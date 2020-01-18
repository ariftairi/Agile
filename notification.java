package com.blood.donation.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blood.donation.R;
import com.blood.donation.controller.UserController;
import com.blood.donation.http.NotificationRequest;
import com.blood.donation.model.Notification;

public class NotificationActivity extends AppCompatActivity implements NotificationRequest.NotificationRespone, AdapterView.OnItemClickListener {
    private ListView notificationList;
    private NotificationAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_activity);

        notificationList = findViewById(R.id.notificationList);

        new NotificationRequest(this).getNotifications();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }

    @Override
    public void onSuccess() {
        mAdapter = new NotificationAdapter(this, UserController.getNotifications());
        notificationList.setAdapter(mAdapter);

        notificationList.setOnItemClickListener(this);
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Notification notification = (Notification) parent.getItemAtPosition(position);

        UserController.selectedNotification = notification;
        Log.i("TAG", "onItemClick: " + notification.getReporterContact());

        startActivity(new Intent(this, NotificationDetails.class));
    }
}