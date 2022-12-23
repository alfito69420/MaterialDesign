package com.example.material;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.PopupMenu;

import com.google.android.material.chip.Chip;

public class MainActivity extends AppCompatActivity {

    private Chip chipSecond, chipThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CHIP ACTIONS
        chipSecond = (Chip) findViewById(R.id.chip_second);
        chipThird = (Chip) findViewById(R.id.chip_third);

        chipSecond.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Hola", Toast.LENGTH_SHORT).show();
                }
            }
        });

        chipThird.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.isClickable()) {
                    chipThird.setVisibility(View.GONE);
                }
            }
        });
    }//cierra el onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_options, menu);
        return super.onCreateOptionsMenu(menu);
    }
}//cierra la clase