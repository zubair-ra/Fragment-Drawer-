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
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerlay);
        navigationView = findViewById(R.id.navigation);
        toolbar = findViewById(R.id.toobar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle togle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Operd, R.string.Closed);
        drawerLayout.addDrawerListener(togle);
        togle.syncState();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentshow, new Default())
                .commit();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.showProfileItem) {
                    System.out.println("id: profile");
                    loadFragment(new Profile());
                } else if (id == R.id.startQuizItem) {
                    loadFragment(new Quiz());
                    System.out.println("id: quiz");
                } else if (id == R.id.showResultItem) {
                    loadFragment(new MyResult());
                    System.out.println("id: result");
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
        private void loadFragment(Fragment fragment){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.contentshow, fragment);
            fragmentTransaction.commit();

    }
}