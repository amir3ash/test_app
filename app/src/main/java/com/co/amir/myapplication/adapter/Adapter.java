package com.co.amir.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.co.amir.myapplication.R;
import com.co.amir.myapplication.databinding.RecyclerItemBinding;
import com.co.amir.myapplication.model.Person;
import com.co.amir.myapplication.model.PersonDbModel;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Person> people;

public Adapter (ArrayList<Person> p){
    if(people!=null)
        people=p;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerItemBinding recyclerItemBinding=
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.recycler_item, viewGroup, false);
        return new ViewHolder(recyclerItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Person person=people.get(i);
        viewHolder.bind(person);
    }

    @Override
    public int getItemCount() {
        return people != null ? people.size() : 0;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerItemBinding binding;
        ViewHolder(RecyclerItemBinding recyclerItemBinding){
            super(recyclerItemBinding.getRoot());
            binding=recyclerItemBinding;
        }

        public void bind(Person person){
            binding.setModel(person);
            binding.executePendingBindings();
        }
    }
}
