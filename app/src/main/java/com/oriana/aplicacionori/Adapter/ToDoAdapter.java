package com.oriana.aplicacionori.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oriana.aplicacionori.Model.ToDoModel;
import com.oriana.aplicacionori.R;
import com.oriana.aplicacionori.TareaActivity;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    private List<ToDoModel> todoList;
    private TareaActivity activity;

    public ToDoAdapter(TareaActivity activity) {

        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_task, parent, false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        ToDoModel item = todoList.get(position);
        holder.task.setText(item.getTask());
        holder.task.setChecked(toBoolean(item.getStatus()));



    }

    public int getItemCount() {
    return todoList.size();
    }
    private boolean toBoolean (int n ) {
    return n!=0;
    }

    public void setTask(List<ToDoModel> todoList){
        this.todoList = todoList;
        notifyDataSetChanged();
    }



        public static class ViewHolder extends RecyclerView.ViewHolder {
            CheckBox task;

            ViewHolder(View view) {
                super(view);
                task = view.findViewById(R.id.todoCheckBox);
            }
        }
    }
