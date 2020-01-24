package com.co.amir.myapplication.ui.mainactivity2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.co.amir.myapplication.R;
import com.co.amir.myapplication.adapter.Adapter;
import com.co.amir.myapplication.databinding.MainActivity2FragmentDashboardBinding;
import com.co.amir.myapplication.model.Person;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_dashboard.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_dashboard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_dashboard extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private MainActivity2ViewModel mViewModel;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment_dashboard() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_dashboard.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_dashboard newInstance(String param1, String param2) {
        Fragment_dashboard fragment = new Fragment_dashboard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivity2ViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MainActivity2FragmentDashboardBinding binding= DataBindingUtil.inflate(
                inflater,R.layout.main_activity2_fragment_dashboard,container,false);

        RecyclerView recyclerView=binding.recycler;
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        ArrayList<Person> people=new ArrayList<>();
        people.add(new Person().setPerson("amir","ASH1"));
        people.add(new Person().setPerson("mohsen","MSH"));
        people.add(new Person().setPerson("zahra","ZSH"));
        people.add(new Person().setPerson("amir","ASH2"));
        people.add(new Person().setPerson("mohsen","MSH"));
        people.add(new Person().setPerson("zahra","ZSH"));
        people.add(new Person().setPerson("amir","ASH3"));
        people.add(new Person().setPerson("mohsen","MSH"));
        people.add(new Person().setPerson("zahra","ZSH"));
        people.add(new Person().setPerson("amir","ASH4"));
        people.add(new Person().setPerson("mohsen","MSH"));
        people.add(new Person().setPerson("zahra","ZSH"));
        people.add(new Person().setPerson("amir","ASH5"));
        people.add(new Person().setPerson("mohsen","MSH"));
        people.add(new Person().setPerson("zahra","ZSH"));
        people.add(new Person().setPerson("amir","ASH6"));
        people.add(new Person().setPerson("mohsen","MSH"));
        people.add(new Person().setPerson("zahra","ZSH"));
        people.add(new Person().setPerson("amir","ASH7"));
        people.add(new Person().setPerson("mohsen","MSH"));
        people.add(new Person().setPerson("zahra","ZSH"));
        people.add(new Person().setPerson("amir","ASH8"));
        people.add(new Person().setPerson("mohsen","MSH"));
        people.add(new Person().setPerson("zahra","ZSH"));


        Adapter adapter=new Adapter(people);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
