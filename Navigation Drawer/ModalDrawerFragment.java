package com.aliomexico.alfitoo.material;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class ModalDrawerFragment extends DialogFragment implements
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private MaterialToolbar materialToolbar;
    private NavigationView navigationView;

    public ModalDrawerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,
                com.google.android.material.R.style.ShapeAppearanceOverlay_MaterialComponents_MaterialCalendar_Window_Fullscreen);
    }//close onCrerate

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_modal_drawer, container, false);

        materialToolbar = view.findViewById(R.id.MaterialToobal);
        navigationView = view.findViewById(R.id.navView);
        drawerLayout = view.findViewById(R.id.drawer_layouooo);

        ((AppCompatActivity)getActivity()).setSupportActionBar(materialToolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(),
                drawerLayout,
                materialToolbar,
                R.string.dialog_ok,
                R.string.dialog_cancel);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_cancel:
                drawerLayout.closeDrawer(GravityCompat.START);
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
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}//close class