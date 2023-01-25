package com.example.material;

import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class AppBarBottomFragment extends DialogFragment {

    public static final String TAG2 = "AppBarBottomFragment";

    private BottomAppBar bottomAppBar;
    private FloatingActionButton floatingActionButton;
    private CoordinatorLayout coordinatorLayout;

    private Boolean isCentered = false;

    public AppBarBottomFragment() {
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
        View view = inflater.inflate(R.layout.fragment_app_bar_bottom, container, false);

        coordinatorLayout = view.findViewById(R.id.container_main);
        floatingActionButton = view.findViewById(R.id.fab);
        bottomAppBar = view.findViewById(R.id.bottom_app_bar);

        bottomAppBar.setOnMenuItemClickListener(item -> {
            int resMesssage;
            switch (item.getItemId()) {
                case R.id.action_favorites:
                    //  Item favorites
                    resMesssage = R.string.menu_favorites;
                    break;
                case R.id.action_profile:
                    //  Item profile
                    resMesssage = R.string.menu_profile;
                    break;
                default:
                    //  Item start
                    resMesssage = R.string.menu_start;
                    break;
            }

            Snackbar.make(coordinatorLayout, resMesssage, Snackbar.LENGTH_LONG)
                    .setAnchorView(floatingActionButton)
                    .show();
            return true;
        });

        bottomAppBar.setNavigationOnClickListener(v -> {
            Snackbar.make(coordinatorLayout, "La acción se realizó con éxito", Snackbar.LENGTH_LONG)
                    .setAnchorView(floatingActionButton)
                    .show();
        });

        //  Animación del fab
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCentered) {
                    bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
                } else {
                    bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                }

                isCentered = !isCentered;
            }
        });

        return view;
    }
}