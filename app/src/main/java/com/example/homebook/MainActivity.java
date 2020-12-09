package com.example.homebook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

/**
 * Main Activity:
 * This Activity will hold the fragments
 * @author Omar Yousef
 * @version 1.0
 * @since NOV 1st
 */
public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView appTitle;

    @Override
    public void onResume() {
        super.onResume();

        //If the grey theme is selected
        if (sharedPreferences.getBoolean("grey_theme", false) == true){
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        }else{
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        }

        //If the Clear animations is selected
        if (sharedPreferences.getBoolean("clear_animations", false) == true){

        }

        //If the Black title is selected
        appTitle = findViewById(R.id.appTitle);
        if (sharedPreferences.getBoolean("title_color", false) == true){
            appTitle.setTextColor(Color.BLACK);
        }else{
            appTitle.setTextColor(Color.WHITE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            Change the Apps Header
         */
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);


        /*
            Shared Preferences (Settings menu)
         */
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_mortgage, R.id.nav_jobs, R.id.nav_contact)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings){
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}