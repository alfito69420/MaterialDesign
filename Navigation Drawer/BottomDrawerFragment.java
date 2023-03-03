package com.aliomexico.alfitoo.material;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomDrawerFragment extends DialogFragment {

    private BottomAppBar bottomAppBar;

    public BottomDrawerFragment() {
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
        View view = inflater.inflate(R.layout.fragment_bottom_drawer, container, false);
        bottomAppBar = view.findViewById(R.id.bottom_app_bar);

        bottomAppBar.setNavigationOnClickListener(v -> {
            new ModalBottomSheetFragment().show(getChildFragmentManager(), "ModalBottomSheetFragment");
        });
        // Inflate the layout for this fragment
        return view;
    }
}