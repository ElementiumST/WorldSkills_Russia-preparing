package com.example.worldskillsrussia.ui.utils;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.worldskillsrussia.MainActivity;

import java.io.File;
import java.io.FileReader;

public class DataBaseUtils {
    private AppCompatActivity root;
    public DataBaseUtils(AppCompatActivity root) {
        this.root = root;
    }
    public boolean autoLogin() {
        File f = new File("app//data//login.txt");
        if(!f.exists())
            try {f.createNewFile(); return false;} catch (Exception e) {
                Toast.makeText(root.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);}
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
                if(hasInDatabase(login, pass)) {
                    MainActivity.setlogin(login, pass); return true;}
                else return false;
            } catch (Exception e)  {Toast.makeText(root.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);}

        } else{ Toast.makeText(root.getApplicationContext(), "I cant read login data", Toast.LENGTH_SHORT);}

        return  false;
    }
    public static boolean hasInDatabase(String login, String pass) {
        return true;
        //TODO Связь с датабазой
    }
}
