package com.oriana.aplicacionori;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.oriana.aplicacionori.Adapter.ToDoAdapter;
import com.oriana.aplicacionori.Model.ToDoModel;
import com.oriana.aplicacionori.Utils.DataBaseHandler;
import com.oriana.aplicacionori.databinding.ActivityTareaBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TareaActivity extends AppCompatActivity implements DialogCloseListener{

    private RecyclerView taskRecyclerView;
    private ToDoAdapter tasksAdapter;
    private FloatingActionButton fab, allTask;
    private List<ToDoModel> taskList;
    private DataBaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea);

        db = new DataBaseHandler(this);
        db.openDatabase();

        // Verificar si getSupportActionBar() devuelve null
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        taskList = new ArrayList<>();

        taskRecyclerView = findViewById(R.id.tasksRecyclerView);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new ToDoAdapter(db,this);
        taskRecyclerView.setAdapter(tasksAdapter);

        fab = findViewById(R.id.fab);
        allTask = findViewById(R.id.allTask);

        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new RecyclerItemTouchHelper(tasksAdapter));
        itemTouchHelper.attachToRecyclerView(taskRecyclerView);

        taskList = db.getAllTasks();
        Collections.reverse(taskList);

        tasksAdapter.setTasks(taskList);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewTask.newInstance().show(getSupportFragmentManager(),AddNewTask.TAG);
            }
        });

        allTask.setOnClickListener(v -> {
            Intent i = new Intent(TareaActivity.this, TaskListFireActivity.class);
            startActivity(i);
        });
    }
    @Override
    public void handleDialogClose(DialogInterface dialog){
        taskList = db.getAllTasks();
        Collections.reverse(taskList);
        tasksAdapter.setTasks(taskList);
        tasksAdapter.notifyDataSetChanged();
    }
}