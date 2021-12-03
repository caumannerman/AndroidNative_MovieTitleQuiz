package com.example.sample;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.textfield.TextInputEditText;

public class FinishActivity extends AppCompatActivity {

    TextView textView;
    Button button_finishapp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_finish);


        textView = findViewById(R.id.textView);
        button_finishapp = findViewById(R.id.button_finishapp);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String cornum = bundle.getString("cornum");
        textView.setText("맞춘 문제 수 : "+cornum);



        //앱을 종료하는 버튼
        button_finishapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveTaskToBack(true);
                finishAndRemoveTask();
                android.os.Process.killProcess(android.os.Process.myPid());
                //System.exit(0);



            }
        });





    }








}