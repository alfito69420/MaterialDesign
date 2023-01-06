package com.example.material;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private Button btnDlgInfo, btnDljChooser, btnDljConfirm, btnDljFullScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDlgInfo = findViewById(R.id.btnDialogInfo);
        btnDljChooser = findViewById(R.id.btnDialogChooser);
        btnDljConfirm = findViewById(R.id.btnDialogConfirm);
        btnDljFullScreen = findViewById(R.id.btnDialogFullScreen);

        btnDlgInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Dialog Informativo")
                        .setPositiveButton("Ok", null)
                        .show();
            }
        });

        btnDljChooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.select_dialog_item);
                adapter.add("Opción 1");
                adapter.add("Opción 2");
                adapter.add("Opción 3");

                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Dialog Chooser")
                        .setAdapter(adapter, (dialog, which) ->
                                Toast.makeText(MainActivity.this,
                                        adapter.getItem(which), Toast.LENGTH_SHORT).show())
                        .show();
            }
        });

        btnDljConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new MaterialAlertDialogBuilder(MainActivity.this)
                //new MaterialAlertDialogBuilder(MainActivity.this,
                //        com.google.android.material.R.style.ThemeOverlay_MaterialComponents_Dialog)
                new MaterialAlertDialogBuilder(MainActivity.this,
                        com.google.android.material.R.style.MaterialAlertDialog_MaterialComponents_Title_Icon)
                        .setTitle("Dialog Confirm")
                        .setMessage("Lorem ipsum")
                        .setPositiveButton("Confirmar", (dialog, which) ->
                                Toast.makeText(MainActivity.this,
                                        "Confirmación exitosa", Toast.LENGTH_SHORT).show())
                        .setNegativeButton("Cancelar", null)
                        .show();
            }
        });

        btnDljFullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentDialogFullScreen fragmentDialogFullScreen = new FragmentDialogFullScreen();
                fragmentDialogFullScreen.show(getSupportFragmentManager(), FragmentDialogFullScreen.TAG);
            }
        });
    }//cierra el onCreate
}//cierra la clase