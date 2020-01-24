package com.co.amir.myapplication.ui.mainactivity2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

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

//       AppDatabase db= AppDatabase.getDatabase(getContext());
//        PersonDao personDao=db.personDao();
        Person person1=new Person().setPerson("hello","56");
//        personDao.insertAll(person1);
        Repository repo =new Repository(getContext());
        repo.insert(person1);
        if(repo.getAllPersons()==null)
           Log.i("jjjjj222 : ","name is Null !    error ");
        else {
            Log.i("this22222 : ","this is not empty");
//            Log.i("thdidfsdf2222 : ",repo.getAllPersons().getValue().name);
//            for (Person s:personDao.getAll()
//                 ) {Log.i("dgDgdgg : ",s.name+"  "+s.age+String.valueOf(s.uid));
//
//            }
        }


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
