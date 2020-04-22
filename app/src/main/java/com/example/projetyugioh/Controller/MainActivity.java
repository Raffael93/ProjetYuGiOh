package com.example.projetyugioh.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetyugioh.R;

public class MainActivity extends AppCompatActivity {

    private Button button,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCard();
                pushNotificationOnClick();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                openRule();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBanlist();
            }
        });


    }
    public void pushNotificationOnClick(){

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notify = new Notification.Builder(getApplicationContext()).setContentTitle("Notification").setContentText("Clicked").setSmallIcon(R.drawable.ic_launcher_foreground).build();
        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0,notify);
    }

    public void openCard(){
        Intent intent3 = new Intent(this, AllCards.class);
        startActivity(intent3);
    }

    public void openRule(){
        Intent intent = new Intent(this, Rule.class);
        startActivity(intent);
    }

    public void openBanlist(){
        Intent intent2 = new Intent(this, Banlist.class);
        startActivity(intent2);

    }


}
