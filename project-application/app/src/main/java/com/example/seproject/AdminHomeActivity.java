package com.example.seproject;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AdminHomeActivity extends AppCompatActivity {

    private static final int COLOR_ACTIVE   = 0xFF27374D;
    private static final int COLOR_INACTIVE = 0xFF111111;

    private ImageView navHomeIcon, navScanIcon, navPassesIcon, navProfileIcon;
    private TextView  navHomeText, navScanText, navPassesText, navProfileText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        navHomeIcon    = findViewById(R.id.navHomeIcon);
        navScanIcon    = findViewById(R.id.navScanIcon);
        navPassesIcon  = findViewById(R.id.navPassesIcon);
        navProfileIcon = findViewById(R.id.navProfileIcon);

        navHomeText    = findViewById(R.id.navHomeText);
        navScanText    = findViewById(R.id.navScanText);
        navPassesText  = findViewById(R.id.navPassesText);
        navProfileText = findViewById(R.id.navProfileText);

        LinearLayout navHome      = findViewById(R.id.navHome);
        LinearLayout navScan      = findViewById(R.id.navScan);
        LinearLayout navAdminMenu = findViewById(R.id.navAdminMenu);
        LinearLayout navPasses    = findViewById(R.id.navPasses);
        LinearLayout navProfile   = findViewById(R.id.navProfile);

        navHome.setOnClickListener(v      -> activateTab(0));
        navScan.setOnClickListener(v      -> activateTab(1));
        navAdminMenu.setOnClickListener(v -> activateTab(2));
        navPasses.setOnClickListener(v    -> activateTab(3));
        navProfile.setOnClickListener(v   -> activateTab(4));

        activateTab(0);
    }

    private void activateTab(int tab) {
        int[] outlineIcons = {
            R.drawable.ic_home,
            R.drawable.ic_scan,
            R.drawable.ic_passes,
            R.drawable.ic_profile
        };
        int[] filledIcons = {
            R.drawable.ic_home_filled,
            R.drawable.ic_scan_filled,
            R.drawable.ic_passes_filled,
            R.drawable.ic_profile_filled
        };

        ImageView[] icons = { navHomeIcon, navScanIcon, navPassesIcon, navProfileIcon };
        TextView[]  texts = { navHomeText, navScanText, navPassesText, navProfileText };

        int iconIndex = (tab < 2) ? tab : (tab > 2) ? tab - 1 : -1;

        for (int i = 0; i < icons.length; i++) {
            boolean isActive = (i == iconIndex);
            icons[i].setImageResource(isActive ? filledIcons[i] : outlineIcons[i]);
            icons[i].setColorFilter(
                new PorterDuffColorFilter(isActive ? COLOR_ACTIVE : COLOR_INACTIVE,
                    PorterDuff.Mode.SRC_IN));
            texts[i].setTextColor(isActive ? COLOR_ACTIVE : COLOR_INACTIVE);
        }
    }
}
