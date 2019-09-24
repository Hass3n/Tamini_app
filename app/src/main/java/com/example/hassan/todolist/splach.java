package com.example.hassan.todolist;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hassan.todolist.ToDolist.TodoListActivity;

public class splach extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(splach.this, TodoListActivity.class));
               finish();
            }
        },3000);
    }
}
