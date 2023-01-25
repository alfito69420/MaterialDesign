package com.example.material;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.material.databinding.ActivityMainBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        activityMainBinding.btnAppBarTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppBarTopFragment appBarTopFragment = new AppBarTopFragment();
                appBarTopFragment.show(getSupportFragmentManager(), AppBarTopFragment.TAG);
            }
        });

        activityMainBinding.btnAppBarBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppBarBottomFragment appBarBottomFragment = new AppBarBottomFragment();
                appBarBottomFragment.show(getSupportFragmentManager(), AppBarBottomFragment.TAG2);
            }
        });
    }//cierra el onCreate
}//cierra la clase