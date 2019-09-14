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

import com.example.worldskillsrussia.MainActivity;
import com.example.worldskillsrussia.R;
import com.example.worldskillsrussia.ui.home.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    int REG_CODE = 1377;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                EditText login = findViewById(R.id.username);
                EditText pass = findViewById(R.id.password);

                if(login.getText().toString().length() == 0 || pass.getText().toString().length() == 0) {
                    System.out.println(1);

                    ((TextView) findViewById(R.id.errorlog)).setText("Введите имя пользователя и пароль");
                }
                else if(!UserData.hasInDatabase(login.getText().toString(), pass.getText().toString())) {
                    System.out.println(2);
                    ((TextView) findViewById(R.id.errorlog)).setText("Неправильное имя пользователя или пароль");
                    login.setBackgroundColor(Color.RED);
                    pass.setBackgroundColor(Color.RED);
                    pass.getText().clear();
                }
                else {
                    System.out.println(3);
                    Intent data = new Intent();
                    data.putExtra("email", login.getText().toString());
                    data.putExtra("pass", pass.getText().toString());
                    setResult(RESULT_OK, data);
                    finish();

                }
                break;
            case R.id.register_button:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivityForResult(intent, REG_CODE);
                break;
            case R.id.login_facebook:
                Toast.makeText(this, "Пока недоступно", Toast.LENGTH_LONG);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(RESULT_OK == resultCode && REG_CODE == requestCode){
            ((TextView) findViewById(R.id.username)).setText(data.getStringExtra("email"));
            ((TextView) findViewById(R.id.password)).setText(data.getStringExtra("pass"));
        }
        else super.onActivityResult(requestCode, resultCode, data);
    }
}
