package com.example.tilek_shambetaliev_hw3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail, txtMessage, nameSms;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initListener() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMessage();

            }
        });
    }

    private void openMessage() {
        final Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{txtEmail.getText().toString()});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,nameSms.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT,txtMessage.getText().toString());
        emailIntent.putExtra(
                Intent.EXTRA_STREAM,
                Uri.parse("file://" + Environment.getExternalStorageDirectory()
                +"/Клипы/SOTY_ATHD.mp4"));
        emailIntent.setType("text/video");

        MainActivity.this.startActivity(Intent.createChooser(emailIntent, "send message"));
    }

    private void initView() {
        txtEmail = findViewById(R.id.txt_email);
        txtMessage = findViewById(R.id.txt_message);
        nameSms = findViewById(R.id.name_sms);
        btnSend = findViewById(R.id.btn_send);
    }
}