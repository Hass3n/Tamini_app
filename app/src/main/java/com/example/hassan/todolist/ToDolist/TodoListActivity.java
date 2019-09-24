package com.example.hassan.todolist.ToDolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hassan.todolist.MainActivity;
import com.example.hassan.todolist.R;
import com.example.hassan.todolist.ToDolist.Adapters.TodosAdapter;
import com.example.hassan.todolist.ToDolist.DataBase.Model.Todo;
import com.example.hassan.todolist.ToDolist.DataBase.MyDataBase;
import com.example.hassan.todolist.splach;


import java.util.List;

public class TodoListActivity extends AppCompatActivity {

    TodosAdapter adapter;
    RecyclerView recyclerView;
    SearchView searchView;
    LinearLayoutManager layoutManager;

    List<Todo>item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_todo_list);
        searchView=findViewById(R.id.searchView);
        recyclerView= findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
            adapter = new TodosAdapter(item,this);
               adapter.setOnItemClickListener(new TodosAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos, Todo item) {
                AddTodo.todoItem= item;
                startActivity(new Intent(TodoListActivity.this,AddTodo.class));
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));

        recyclerView.setAdapter(adapter);
          searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
              @Override
              public boolean onQueryTextSubmit(String s) {
                  return false;
              }

              @Override
              public boolean onQueryTextChange(String s) {
                  String text=s;
                  adapter.filter(text);
                  return false;
              }
          });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
             startActivity(new Intent(TodoListActivity.this,AddTodo.class));
            }
        });

       }



    @Override
    protected void onResume() {
        super.onResume();
        item= MyDataBase.getDataBaseInstance(this)
                .todoDao()
                .SelectAllTodo();

        adapter.setDate(item);


    }
}
