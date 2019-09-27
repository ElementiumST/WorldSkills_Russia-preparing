package com.example.worldskillsrussia.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.worldskillsrussia.MainActivity;
import com.example.worldskillsrussia.R;
import com.example.worldskillsrussia.data.UserData;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button btn = findViewById(R.id.start_register_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView name = (TextView) findViewById(R.id.reg_name_lable);
                TextView mail = (TextView) findViewById(R.id.reg_mail);
                TextView stat = (TextView) findViewById(R.id.reg_stat);
                TextView pass = (TextView) findViewById(R.id.reg_pass);
                TextView rpass = (TextView) findViewById(R.id.reg_rem_pass);
                boolean allRight = true;

                 if(name.getText().length() < 2){
                    name.clearComposingText();
                    name.setHint("Имя должно содержать больше 2х знаклв");
                    name.setBackgroundColor(Color.RED);
                     allRight = false;


                 } else  name.setBackgroundColor(Color.GREEN);
                 if(!mail.getText().toString().contains("@")) {
                     mail.clearComposingText();mail.setHint("Некорректно введен адресс");
                     mail.setBackgroundColor(Color.RED);
                     allRight = false;

                 }
                 else if(mail.getText().length() < 5){
                    mail.clearComposingText();
                    mail.setHint("Адресс почты должен быть длиннее 4х символов");
                    mail.setBackgroundColor(Color.RED);
                     allRight = false;

                 } else  mail.setBackgroundColor(Color.GREEN);
                if(!UserData.hasStatusInDatabase(stat.getText().toString())){
                    stat.clearComposingText();
                    stat.setHint("Данный статус не существует");
                    stat.setBackgroundColor(Color.RED);
                    allRight = false;

                } else  stat.setBackgroundColor(Color.GREEN);
                if(pass.getText().length() < 6){
                    pass.clearComposingText();
                    pass.setHint("Пароль должен быть больше 5 символов");
                    pass.setBackgroundColor(Color.RED);
                    allRight = false;

                } else  pass.setBackgroundColor(Color.GREEN);
                if(!pass.getText().toString().equals(rpass.getText().toString())) {
                    pass.clearComposingText();
                    rpass.clearComposingText();
                    rpass.setHint("Пароли не совпадают");
                    rpass.setBackgroundColor(Color.RED);
                    allRight = false;
                } else  rpass.setBackgroundColor(Color.GREEN);

                if(allRight) {



                    MainActivity.databaseCollector.createUser(new UserData(name.getText().toString(), mail.getText().toString().replace('.',','), pass.getText().toString(), null, stat.getText().toString()));
                    Intent data = new Intent();
                    data.putExtra("email", mail.getText().toString());
                    data.putExtra("pass", pass.getText().toString());
                    setResult(RESULT_OK, data);
                    finish();
                }

            }
        });

    }

    public boolean addToDatabase(UserData ud){
        return true; //TODO Database add
    }
}
