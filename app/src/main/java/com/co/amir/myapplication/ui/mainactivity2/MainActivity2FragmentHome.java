package com.co.amir.myapplication.ui.mainactivity2;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.co.amir.myapplication.R;
import com.co.amir.myapplication.databinding.MainActivity2FragmentHomeBinding;
import com.co.amir.myapplication.model.Person;

public class MainActivity2FragmentHome extends Fragment {

    private MainActivity2ViewModel mViewModel;

    public static MainActivity2FragmentHome newInstance() {
        return new MainActivity2FragmentHome();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        MainActivity2FragmentHomeBinding binding=DataBindingUtil.inflate(
                inflater,R.layout.main_activity2_fragment_home,
                container,false);

         View view=binding.getRoot();
        Person p=new Person();p.setName("amir");
        binding.setModel(p);
        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivity2ViewModel.class);
        mViewModel.text.set("First");
        binding.setViewmodel(mViewModel);
         return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // mViewModel = ViewModelProviders.of(getActivity()).get(MainActivity2ViewModel.class);
        // TODO: Use the ViewModel

    }


}
