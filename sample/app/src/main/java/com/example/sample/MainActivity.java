package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edit_email, edit_password;
    Button button_login;

    String emailOK = "admin@test.com";
    String passwordOK = "admin1!";

    String inputEmail = "";
    String inputPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        button_login = findViewById(R.id.button_login);


        //1. 값을 가져온다.
        //2. 클릭을 감지
        //3. 가져온 값을 다음 액티비티로 넘긴다.


        button_login.setClickable(false);
        button_login.setEnabled(false);

        edit_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Log.d("Log testing...", s + ","+count);
                //이곳에서 ID검사
                if(s != null){
                    inputEmail = s.toString();
                    button_login.setClickable(validation());
                    button_login.setEnabled(validation());
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edit_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Log.d("Log testing...", s + ","+count);
                if(s != null){
                    inputPassword = s.toString();
                    button_login.setClickable(validation());
                    button_login.setEnabled(validation());
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



       // button_login.setClickable(true);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edit_email.getText().toString();
                String password = edit_password.getText().toString();

                Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });


    }

    public boolean validation(){
        return  (inputEmail.equals(emailOK)  && inputPassword.equals(passwordOK));
    }
}