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

    private Button btnCmr;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCmr = findViewById(R.id.button_camara);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.tie_1);

        btnCmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_options, popupMenu.getMenu());
                popupMenu.show();
            }
        });

        String[] courses = new String[]{"Equisde", "Mojojo", "AlioMX", "Yofo"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                R.layout.item_menu_dropdown, courses);

        autoCompleteTextView.setAdapter(adapter);
    }//cierra el onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_options, menu);
        return super.onCreateOptionsMenu(menu);
    }
}//cierra la clase