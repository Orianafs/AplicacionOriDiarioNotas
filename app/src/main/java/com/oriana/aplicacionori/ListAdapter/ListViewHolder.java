package com.oriana.aplicacionori.ListAdapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oriana.aplicacionori.Model.ToDoModel;
import com.oriana.aplicacionori.databinding.CardViewTaskBinding;

public class ListViewHolder extends RecyclerView.ViewHolder {
    private CardViewTaskBinding binding;
    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = CardViewTaskBinding.bind(itemView);
    }
    public void RenderList(ToDoModel toDo){
        binding.todoCheckBox.setText(toDo.getTask());
    }
}
