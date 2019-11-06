package com.co.amir.myapplication.ui.mainactivity2;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.co.amir.myapplication.R;

public class MainActivity2FragmentHome extends Fragment {

    private MainActivity2ViewModel mViewModel;

    public static MainActivity2FragmentHome newInstance() {
        return new MainActivity2FragmentHome();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_activity2_fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivity2ViewModel.class);
        // TODO: Use the ViewModel
    }


}
