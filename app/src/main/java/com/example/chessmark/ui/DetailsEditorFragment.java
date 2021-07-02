package com.example.chessmark.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chessmark.R;
import com.example.chessmark.viewmodels.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsEditorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsEditorFragment extends Fragment {

    MainViewModel mViewModel;

    public DetailsEditorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment DetailsEditorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsEditorFragment newInstance() {
        DetailsEditorFragment fragment = new DetailsEditorFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_editor, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
    }
}