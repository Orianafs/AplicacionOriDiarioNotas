package com.oriana.aplicacionori.ListAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oriana.aplicacionori.Model.ToDoModel;
import com.oriana.aplicacionori.R;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    private ArrayList<ToDoModel> toDoList;

    public ListAdapter(ArrayList<ToDoModel> toDoList) {
        this.toDoList = toDoList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_task, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ToDoModel toDoModel = toDoList.get(position);
        holder.RenderList(toDoModel);
    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }
}
