package com.oriana.aplicacionori.ListAdapter;

import android.os.Build;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.oriana.aplicacionori.Model.ToDoModel;

import java.util.ArrayList;

public class ListViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<ToDoModel>> toDoData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public ListViewModel() {
        loading.setValue(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            ListData.getTaskList().thenAccept(toDoList -> {
                toDoData.postValue(toDoList);
                loading.postValue(false);
            }).exceptionally(throwable -> {
                loading.postValue(false);
                return null;
            });
        }
    }

    public LiveData<ArrayList<ToDoModel>> getToDoData() {
        return toDoData;
    }

    public LiveData<Boolean> isLoading() {
        return loading;
    }
}
