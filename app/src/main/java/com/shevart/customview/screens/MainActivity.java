package com.shevart.customview.screens;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.shevart.customview.R;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bnvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnvMain = findViewById(R.id.bnvMain);
        bnvMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_views:
                        showViews();
                        return true;
                    case R.id.action_about_me:
                        showAboutMe();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void showViews() {

    }

    private void showAboutMe() {

    }
}