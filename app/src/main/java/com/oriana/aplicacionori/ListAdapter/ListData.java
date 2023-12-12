package com.oriana.aplicacionori.ListAdapter;

import android.os.Build;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.oriana.aplicacionori.Model.ToDoModel;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class ListData {

    static ArrayList<ToDoModel> taskList = new ArrayList<>();
    static CompletableFuture<ArrayList<ToDoModel>> futureTask;
    static DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    public static CompletableFuture<ArrayList<ToDoModel>> getTaskList() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            futureTask = new CompletableFuture<>();
        }
        reference.child("Tasks").orderByChild("task").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                taskList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ToDoModel toDoModel = dataSnapshot.getValue(ToDoModel.class);
                    if (toDoModel != null) {
                        String task = toDoModel.getTask();
                        taskList.add(new ToDoModel(0, task));
                    }
                }
                if (taskList.isEmpty()) {
                    // Devolver una lista vacía si no hay resultados
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        futureTask.complete(new ArrayList<>());
                    }
                } else {
                    // Completar el CompletableFuture con la lista de personas
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        futureTask.complete(taskList);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    futureTask.completeExceptionally(new RuntimeException("Error en la consulta a la base de datos"));
                }
            }
        });
        return futureTask;
    }
}
