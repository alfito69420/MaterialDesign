package com.example.material;

import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FragmentDialogFullScreen extends DialogFragment {

    public static final String TAG = "FullScreenDialogFragment";
    private Button btnSave;
    Toolbar toolbar;

    public FragmentDialogFullScreen() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,
                com.google.android.material.R.style.ShapeAppearanceOverlay_MaterialComponents_MaterialCalendar_Window_Fullscreen);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dialog_full_screen, container, false);
        toolbar = view.findViewById(R.id.toolbarFragment);
        toolbar.setNavigationIcon(R.drawable.ic_close);
        toolbar.setNavigationOnClickListener(view1 -> dismiss());
        //ImageView btnClose = view.findViewById(R.id.btnClose);
        //btnClose.setOnClickListener(view1 -> dismiss());
        toolbar.setTitle("Pantalla Completa");

        btnSave = view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Se completó la acción correctamente.", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        return view;
    }
}