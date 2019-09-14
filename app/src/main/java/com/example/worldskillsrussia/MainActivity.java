package com.example.worldskillsrussia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.worldskillsrussia.ui.login.LoginActivity;
import com.example.worldskillsrussia.ui.login.UserData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;

    private boolean firstLaunch = false;
    UserData ud;
    private boolean isAuth;
    private SharedPreferences sharedPreferences;
    private final int USER_DATA = 1320;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (!firstLaunch) {
            ImageView iw = findViewById(R.id.logo);
            Animation logoAnim = AnimationUtils.loadAnimation(this, R.anim.animation);
            iw.startAnimation(logoAnim);
            firstLaunch = true;
        }

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        navigationView = findViewById(R.id.nav_view);


        if(sharedPreferences.contains("IS_LOGINED") && sharedPreferences.getBoolean("IS_LOGINED", true)) {
            ud = UserData.createFromDatabase(sharedPreferences.getString("EMAIL", "unknown"),
                    sharedPreferences.getString("PASSWORD", "unknown"), getResources());
            isAuth = true;
        } else {
            isAuth = false;
            Toast.makeText(getApplicationContext(), "Вы не авторизованны! Контент ограничен.", Toast.LENGTH_LONG).show();

        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    public void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, USER_DATA());

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case USER_DATA:
                    ud = UserData.createFromDatabase(data.getStringExtra("email"), data.getStringExtra("pass"), getResources());
                    if (ud != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        isAuth = true;
                        edit.putBoolean("IS_LOGINED", true);
                        edit.putString("EMAIL", ud.getEmail());
                        edit.putString("PASSWORD", ud.getPass());
                        edit.apply();
                        edit.commit();
                    }
                    break;
            }
        }  else super.onActivityResult(requestCode, resultCode, data);

    }

    public int USER_DATA() {
        return USER_DATA;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public boolean isAuth() {
        return isAuth;
    }

    public void setAuth(boolean auth) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        System.out.println(auth);
        e.putBoolean("IS_LOGINED", auth);
        e.apply();
        e.commit();
        isAuth = auth;
    }

    public UserData getUd() {
        return ud;
    }
    public static boolean isDatabaseOnline() {
        return true; // TODO database connect
    }
}
