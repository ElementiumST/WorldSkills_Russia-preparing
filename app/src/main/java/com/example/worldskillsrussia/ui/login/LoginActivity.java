package com.example.worldskillsrussia.ui.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.worldskillsrussia.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button b = findViewById(R.id.login);
        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
                EditText login = findViewById(R.id.username);
                EditText pass = findViewById(R.id.password);

                if(login.getText().toString().length() == 0 || pass.getText().toString().length() == 0) ((TextView) findViewById(R.id.errorlog)).setText("Введите имя пользователя и пароль");

                else if(!UserData.hasInDatabase(login.getText().toString(), pass.getText().toString())) {
                    if(login.getText().toString().length() == 0 || pass.getText().toString().length() == 0) ((TextView) findViewById(R.id.errorlog)).setText("Неправильное имя пользователя или пароль");
                    login.setBackgroundColor(Color.RED);
                    pass.setBackgroundColor(Color.RED);
                    pass.getText().clear();
                }
                Intent data = new Intent();
                data.putExtra("email", login.getText().toString());
                data.putExtra("pass", pass.getText().toString());
                setResult(RESULT_OK, data);
                System.out.println("+++++++++++++++++++++++++++++++++++++++++");
                System.out.println("finished!");
                System.out.println(login.getText().toString());
                System.out.println(pass.getText().toString());
                System.out.println("+++++++++++++++++++++++++++++++++++++++++");
                finish();
            }
        });
    }
}
