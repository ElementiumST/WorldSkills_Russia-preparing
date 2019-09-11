package com.example.worldskillsrussia;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Bundle;

import com.example.worldskillsrussia.ui.home.Post;

import com.example.worldskillsrussia.ui.utils.DataBaseUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

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

import java.io.File;
import java.io.FileReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AppBarConfiguration mAppBarConfiguration;

    private static boolean isAuth = false;
    private static String email;
    private static String name;
    private static String password;
    private boolean firstLaunch = false;
    DataBaseUtils dbu = new DataBaseUtils(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!dbu.autoLogin())
        {
            Toast.makeText(getApplicationContext(), "Вы не авторизованны! Контент ограничен.", Toast.LENGTH_LONG).show();
        }
        if (!firstLaunch) {
            ImageView iw = findViewById(R.id.logo);
            Animation logoAnim = AnimationUtils.loadAnimation(this, R.anim.animation);
            iw.startAnimation(logoAnim);
            firstLaunch = true;
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Обновление новостей...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        if(email != null) {TextView maill = navigationView.findViewById(R.id.email_header_lable); maill.setText(email);}
        if(name != null) {TextView passl = navigationView.findViewById(R.id.username_header_lable); passl.setText(password);}

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


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onResume() {
        super.onResume();
        NavigationView navigationView = findViewById(R.id.nav_view);
        if(email != null) {TextView maill = navigationView.findViewById(R.id.email_header_lable); maill.setText(email);}
        if(name != null) {TextView passl = navigationView.findViewById(R.id.username_header_lable); passl.setText(password);}


    }

    public boolean isAuth() {
        return isAuth;
    }
    public void setlogin(String nemail, String nname, String npassword) {
        isAuth = true;
        name = nname;
        email = nemail;
        password = npassword;


    }


    public void onClick(View view) {
        if(view.getId() == R.id.user_image && !isAuth()){
            Intent inf = new Intent(this, LoginActivity.class);
            startActivity(inf);
        }
    }


}
