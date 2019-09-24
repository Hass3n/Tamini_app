package com.example.hassan.todolist.ToDolist.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.example.hassan.todolist.ToDolist.DataBase.Model.Todo;

import java.util.List;

@Dao
public interface TodoDao {

    @Insert
    public void InsertTodo(Todo todo);

    @Update
    public void UpdateTodo(Todo todo);

    @Delete
    public void DeleteTodo(Todo todo);

    @Query("select * from Todo;")
    public List<Todo> SelectAllTodo();


}
