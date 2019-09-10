package com.example.worldskillsrussia;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_login);

    }

    public static boolean autoLogin() {
        File f = new File("app.data.login.txt");
        if(f.exists()){
            try {
                FileReader fr = new FileReader(f);
                int i;
                String s = "";
                while((i = fr.read()) != -1){
                    if((char) i == '|') {
                        MainActivity.setLogin(s);
                        continue;
                    } else if (((char) i == '+')) {
                        MainActivity.setPass(s);
                        break;
                    }
                    s += (char) i;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public void save(String login, String pass) {
        File f = new File("app.data.login.txt");
        try{
            if(!f.exists()) f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write(MainActivity.getLogin() +"|" + MainActivity.getPass() + "+");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void onClick(View v) {

    }
}
