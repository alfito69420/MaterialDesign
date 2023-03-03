package com.aliomexico.alfitoo.material;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.aliomexico.alfitoo.material.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

    activityMainBinding.btnModalDrawer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new ModalDrawerFragment().show(getSupportFragmentManager(), "ModalDrawerFragment");
        }
    });
    
    activityMainBinding.btnBottomNavDrawer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new BottomDrawerFragment().show(getSupportFragmentManager(), "BottomDrawerFragment");
        }
    });

    }//close onCreate
}//close class