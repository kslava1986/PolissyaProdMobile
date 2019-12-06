package com.example.pp.activity;

import android.os.Bundle;
import android.view.Menu;

import com.example.pp.R;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_drawer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        DrawerLayout drawerLayout = findViewById(R.id.activity_drawer);
        NavigationView navigationView = findViewById(R.id.nav_drawer_activity);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_drawer_fragment);

        appBarConfiguration = new AppBarConfiguration
                .Builder(navController.getGraph())
                .setDrawerLayout(drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_drawer_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //todo управление поведением меню
        // https://habr.com/ru/post/256643/
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}
