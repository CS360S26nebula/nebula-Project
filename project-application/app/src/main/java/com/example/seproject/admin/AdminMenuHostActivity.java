package com.example.seproject.admin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.seproject.R;

public class AdminMenuHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu_host);

        if (savedInstanceState == null) {
            navigateTo(new AdminMenuFragment(), false);
        }
    }

    public void navigateTo(Fragment fragment, boolean addToBackStack) {
        var tx = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.admin_menu_container, fragment);
        if (addToBackStack) tx.addToBackStack(null);
        tx.commit();
    }
}
