package com.oriana.aplicacionori;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.oriana.aplicacionori.ListAdapter.ListAdapter;
import com.oriana.aplicacionori.ListAdapter.ListViewModel;
import com.oriana.aplicacionori.Model.ToDoModel;
import com.oriana.aplicacionori.databinding.ActivityTaskListFireBinding;

import java.util.ArrayList;

public class TaskListFireActivity extends AppCompatActivity {
    private ActivityTaskListFireBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListViewModel listViewModel = new ViewModelProvider(this).get(ListViewModel.class); //esto se trae la lista
        super.onCreate(savedInstanceState);
        binding = ActivityTaskListFireBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listViewModel.getToDoData().observe(this, this::initRecyclerView);

        listViewModel.isLoading().observe(this, isLoading -> {
            if (isLoading) {
                binding.chargingScreen.setVisibility(View.VISIBLE);
            } else {
                binding.chargingScreen.setVisibility(View.GONE);
            }
        });
    }

    public void initRecyclerView(ArrayList<ToDoModel> toDoList){
        LinearLayoutManager manager = new LinearLayoutManager(binding.recyclerList.getContext()); //Con esto puedo agregar un numero de filas especificas envez de 1
        DividerItemDecoration decoration = new DividerItemDecoration(binding.recyclerList.getContext(), manager.getOrientation());
        binding.recyclerList.setHasFixedSize(true); //Extra
        binding.recyclerList.setItemAnimator(new DefaultItemAnimator());//Extra
        binding.recyclerList.setLayoutManager(manager);
        binding.recyclerList.setAdapter(new ListAdapter(toDoList));
    }
}