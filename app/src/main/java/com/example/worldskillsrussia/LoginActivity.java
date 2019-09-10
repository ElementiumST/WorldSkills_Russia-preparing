package com.example.worldskillsrussia;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(autoLogin()) finish();
        email = findViewById(R.id.email_lable);
        pass = findViewById(R.id.pass_label);
        Button b = findViewById(R.id.login_in_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!email.getText().toString().equals("") || pass.getText().toString().length() > 5){
                    if(hasInDatabase(email.getText().toString(), pass.getText().toString())) {
                        MainActivity.setlogin(email.getText().toString(), pass.getText().toString());

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
    private boolean hasInDatabase(String login, String pass) {
        return true;
        //TODO Связь с датабазой
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
    public boolean autoLogin() {
        File f = new File("app//data//login.txt");
        if(!f.exists())
            try {f.createNewFile(); return false;} catch (Exception e) {Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);}
        if(f.canRead()) {
            try(FileReader fr = new FileReader(f)) {
                String login= "", pass = "";
                String bufer = "";
                int i;
                while((i = fr.read()) != -1) {
                    if("(".equals((char) i)) {
                        login = bufer;
                        bufer = "";
                    } else if(")".equals((char) i)) {
                        pass = bufer;
                        break;
                    }else {
                        bufer += (char) i;
                    }
                }
                if(hasInDatabase(login, pass)) {MainActivity.setlogin(login, pass); return true;}
                else return false;
            } catch (Exception e)  {Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);}

        } else{ Toast.makeText(getApplicationContext(), "I cant read login data", Toast.LENGTH_SHORT);}

        return  false;
    }

}
