package com.example.chessmark.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.chessmark.ui.DetailsEditorFragment;
import com.example.chessmark.ui.OutlineFragment;

public class MasterDetailAdapter extends FragmentStateAdapter {
    // private FragmentActivity mActivity;

    public MasterDetailAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        // mActivity = fragmentActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new OutlineFragment();
        }
        else {
            return new DetailsEditorFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
