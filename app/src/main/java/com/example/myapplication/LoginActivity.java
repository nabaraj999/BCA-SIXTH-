package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText etemail;
    EditText etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnForgotPas = findViewById(R.id.btn_forgot);
        etemail = findViewById(R.id.et_email);
        etpassword = findViewById(R.id.et_password);

        btnForgotPas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Euta activity banuna paryo
                // tyo class ko design pani banaune
                // tyo class ma switch hune code yo button click garda lekhna paryo
                // Log.e("Forgot Button","Forgot buttom le kam garyo");
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);

                startActivity(intent);
            }
        });
    }

    public void onLogicClick(View view) {
        String email = etemail.getText().toString();
        String pass = etpassword.getText().toString();

        if (email.isEmpty()){
            etemail.setError("This field is required");
        }
        if (pass.isEmpty()){
            etpassword.setError("This field is required");
        }

        Log.e("Email tag",email);
        Log.e("Password tag",pass);

        Toast.makeText(LoginActivity.this, "Hello I am Nabaraj", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
       // startActivity(intent); // Missing in your code


    }


    public void onSignupClick(View view) {
        Intent intent = new Intent(LoginActivity.this, registerActivity.class);
        startActivity(intent);
    }
}