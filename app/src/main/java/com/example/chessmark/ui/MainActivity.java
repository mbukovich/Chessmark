package com.example.chessmark.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.chessmark.R;
import com.example.chessmark.adapters.MasterDetailAdapter;
import com.example.chessmark.viewmodels.MainViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private MasterDetailAdapter mViewPagerAdapter;
    private ViewPager2 mViewPager;
    private TabLayout mTabLayout;

    private boolean mIsPortraitPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIsPortraitPhone = true;

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        if (mIsPortraitPhone) {
            // Set up activity for portrait phone
            mViewPager = findViewById(R.id.viewPager2_outline_editor);
            mViewPagerAdapter = new MasterDetailAdapter(this);
            mViewPager.setAdapter(mViewPagerAdapter);

            mTabLayout = findViewById(R.id.tab_layout_outline_editor);
            new TabLayoutMediator(mTabLayout, mViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
                @Override
                public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                    if (position == 0) tab.setText("Outline");
                    else tab.setText("Details Editor");
                }
            }).attach();
        }
        else {
            // TODO set up activity for landscape phone and all tablets
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Add Switch statement to perform an appropriate action when a certain item in the menu is clicked
        // This switch statement will compare item.itemId to the ids of the menu items
        return true;
    }
}