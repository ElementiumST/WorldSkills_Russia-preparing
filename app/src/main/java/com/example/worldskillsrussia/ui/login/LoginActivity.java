package com.example.worldskillsrussia.ui.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.worldskillsrussia.MainActivity;
import com.example.worldskillsrussia.R;
import com.example.worldskillsrussia.data.UserData;
import com.google.firebase.firestore.auth.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Date unlockDate = new Date();
    int counter = 0;
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

                Date date = new Date();
                if(date.before(unlockDate)){
                    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
                    ((TextView) findViewById(R.id.errorlog)).setText("Превышено число попыток, попробуйте ещё раз через "+ sdf.format((new Date((unlockDate).getTime()-(new Date()).getTime()))) );
                    return;
                }
                if(counter == 3) {
                    ((TextView) findViewById(R.id.errorlog)).setText("Превышено число попыток, попробуйте ещё раз через 3 минуты");
                    unlockDate = new Date((new Date()).getTime()+180000);
                    counter = 0;
                }
                counter++;
                EditText login = findViewById(R.id.username);
                EditText pass = findViewById(R.id.password);

                if(login.getText().toString().length() == 0 || pass.getText().toString().length() == 0) {
                    System.out.println(1);

                    ((TextView) findViewById(R.id.errorlog)).setText("Введите имя пользователя и пароль");
                }
                UserData ud = MainActivity.databaseCollector.getUser(login.getText().toString(), pass.getText().toString());
                if(ud == null) {
                    System.out.println(2);
                    ((TextView) findViewById(R.id.errorlog)).setText("Неправильное имя пользователя или пароль");
                    login.setBackgroundColor(Color.RED);
                    pass.setBackgroundColor(Color.RED);
                    pass.getText().clear();
                }
                else {
                    System.out.println(3);
                    Intent data = new Intent();
                    data.putExtra("email", ud.getEmail());
                    data.putExtra("pass", ud.getPass());
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
