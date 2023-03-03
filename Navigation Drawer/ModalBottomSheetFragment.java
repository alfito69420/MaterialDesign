package com.aliomexico.alfitoo.material;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

public class ModalBottomSheetFragment extends BottomSheetDialogFragment implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;

    public ModalBottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modal_bottom_sheet, container, false);

        navigationView = view.findViewById(R.id.navDrawerBottom);

        navigationView.setNavigationItemSelectedListener(this);
        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cancel:
                dismiss();
                break;
            case R.id.action_fragment:
                new BlankFragment().show(getChildFragmentManager(), "BlankFragment");
                Toast.makeText(getContext(), "Operacion realizada con exito.", Toast.LENGTH_SHORT).show();
                break;
            default:
                String msg = item.getTitle().toString();
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                break;
        }
        dismiss();
        return true;
    }
}