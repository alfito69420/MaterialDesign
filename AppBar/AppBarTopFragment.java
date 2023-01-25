package com.example.material;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

public class AppBarTopFragment extends DialogFragment {

    public static final String TAG = "AppBarTopFragment";
    private Button btnSave;
    private MaterialToolbar toolbar;

    public AppBarTopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,
                com.google.android.material.R.style.ShapeAppearanceOverlay_MaterialComponents_MaterialCalendar_Window_Fullscreen);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_app_bar_top, container, false);
        toolbar = view.findViewById(R.id.materialToolbar);
        btnSave = view.findViewById(R.id.btnSaveTop);
        toolbar.setNavigationOnClickListener(view1 -> dismiss());

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