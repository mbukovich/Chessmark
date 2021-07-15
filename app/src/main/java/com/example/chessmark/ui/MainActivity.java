package com.example.chessmark.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.chessmark.R;
import com.example.chessmark.adapters.MasterDetailAdapter;
import com.example.chessmark.viewmodels.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private MasterDetailAdapter mViewPagerAdapter;
    private ViewPager2 mViewPager;
    private TabLayout mTabLayout;
    private FloatingActionButton mFAB;

    private boolean mIsPortraitMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find out the screen orientation
        int orientation = getResources().getConfiguration().orientation;
        mIsPortraitMode = orientation != Configuration.ORIENTATION_LANDSCAPE;

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Set up the Floating Action Button
        mFAB = findViewById(R.id.floatingActionButton);
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BoardEditorActivity.class);
                startActivity(intent);
            }
        });

        if (mIsPortraitMode) {
            // Set up activity for portrait mode
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
            // TODO set up activity for landscape mode
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.container_master_fragment, OutlineFragment.class, null)
                    .add(R.id.container_detail_fragment, DetailsEditorFragment.class, null)
                    .commit();
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