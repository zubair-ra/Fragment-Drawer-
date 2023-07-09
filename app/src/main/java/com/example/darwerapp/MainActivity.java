package com.example.darwerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NonNls;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawerlay);
        navigationView=findViewById(R.id.navigation);
        toolbar=findViewById(R.id.toobar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle togle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Operd,R.string.Closed);
        drawerLayout.addDrawerListener(togle);
        togle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               int id=item.getItemId();


                return true;
            }
        });
        {

        }

    }
}