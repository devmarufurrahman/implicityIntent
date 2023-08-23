package com.example.implicityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMessage, btnDailer, btnShare, btnEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id define
        btnDailer = findViewById(R.id.btnDial);
        btnEmail = findViewById(R.id.btnEmail);
        btnMessage = findViewById(R.id.btnMessage);
        btnShare = findViewById(R.id.btnShare);


        // btnDialer
        btnDailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +8801757474700"));
                startActivity(iDial);
            }
        });


        // btnShare
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare  = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Maruf");
                startActivity(Intent.createChooser(iShare,"Share Via"));
            }
        });


        // btnMessage
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:"+ Uri.encode("+8801757474700"));
                Intent iMsg = new Intent(Intent.ACTION_SENDTO,uri);

                iMsg.putExtra("sms_body","Please solve the issue asap.");
                startActivity(iMsg);
            }
        });



        // btnEmail
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"mdmarufur5682@gmail.com","vangaradio5682@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Test");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Please solve this problem");
                startActivity(Intent.createChooser(iEmail,"Email via"));
            }
        });
    }
}