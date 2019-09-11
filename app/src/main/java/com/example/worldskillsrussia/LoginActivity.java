package com.example.worldskillsrussia;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.worldskillsrussia.ui.utils.DataBaseUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    DataBaseUtils dbu = new DataBaseUtils(this);
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email_lable);
        pass = findViewById(R.id.pass_label);
        Button b = findViewById(R.id.login_in_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!email.getText().toString().equals("") || pass.getText().toString().length() > 5){
                    if(dbu.hasInDatabase(email.getText().toString(), pass.getText().toString())) {
                        setlogin(email.getText().toString(), pass.getText().toString());

                        finish();
                    } else
                    {
                        Toast.makeText(getApplicationContext(), "Неправильное имя пользователя или пароль", Toast.LENGTH_LONG);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                            email.setBackgroundColor(Color.RED);
                            pass.setBackgroundColor(Color.RED);
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Введите имя пользователся или пароль", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void save(String login, String pass){
        File f = new File("app//data//login.txt");
        if(!f.exists())
            try {f.createNewFile(); } catch (Exception e) {Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);}
        if(f.canWrite()) {
            try(FileWriter fw = new FileWriter(f)) {
                fw.write(login+"(" + pass + ")");
            } catch (Exception e)  {Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);}

        } else{ Toast.makeText(getApplicationContext(), "I cant write login data", Toast.LENGTH_SHORT);}

    }


}
