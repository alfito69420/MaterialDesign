package com.example.material;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.material.databinding.ActivityMainBinding;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        coordinatorLayout = findViewById(R.id.containerMain);

        activityMainBinding.btnPickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
                builder.setTitleText("Calendario");
                //  Sets the actual date as the selection
                builder.setSelection(System.currentTimeMillis());
                builder.setTheme(com.google.android.material.R.style.ThemeOverlay_MaterialComponents_MaterialCalendar);

                MaterialDatePicker<?> picker = builder.build();
                picker.addOnPositiveButtonClickListener(selection ->
                        Snackbar.make(coordinatorLayout, picker.getHeaderText(), Snackbar.LENGTH_SHORT).show());
                picker.addOnNegativeButtonClickListener(v1 ->
                        Snackbar.make(coordinatorLayout, "Negative option", Snackbar.LENGTH_SHORT).show());
                picker.addOnCancelListener(dialog ->
                        Snackbar.make(coordinatorLayout, "Canceled", Snackbar.LENGTH_SHORT).show());
                picker.show(getSupportFragmentManager(), picker.toString());
            }
        });

        activityMainBinding.btnPickerFullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
                builder.setTitleText("Calendario");
                builder.setSelection(System.currentTimeMillis());
                //  The main theme will change the color of the status bar
                //  to fix it it is necessary to create a new theme pointing
                //  to main theme 'ThemeOverlay...' as the father and add
                //  an item wich propiety will fix the issue.
                builder.setTheme(com.google.android.material.R.style.ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen);

                MaterialDatePicker<?> picker = builder.build();
                picker.addOnPositiveButtonClickListener(selection ->
                        Snackbar.make(coordinatorLayout, picker.getHeaderText(), Snackbar.LENGTH_SHORT).show());
                picker.addOnNegativeButtonClickListener(v1 ->
                        Snackbar.make(coordinatorLayout, "Negative option", Snackbar.LENGTH_SHORT).show());
                picker.addOnCancelListener(dialog ->
                        Snackbar.make(coordinatorLayout, "Canceled", Snackbar.LENGTH_SHORT).show());
                picker.show(getSupportFragmentManager(), picker.toString());
            }
        });
    }//cierra el onCreate
}//cierra la clase