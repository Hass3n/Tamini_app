package com.example.hassan.todolist.ToDolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.hassan.todolist.MainActivity;
import com.example.hassan.todolist.R;
import com.example.hassan.todolist.ToDolist.Adapters.TodosAdapter;
import com.example.hassan.todolist.ToDolist.DataBase.Model.Todo;
import com.example.hassan.todolist.ToDolist.DataBase.MyDataBase;

import java.util.ArrayList;
import java.util.List;


public class AddTodo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    List<Todo>item;
    private EditText c_name;
    private EditText c_phone;
    private EditText c_dateTime;
    private EditText c_middle;
    private EditText c_value;
    private EditText c_middlee;
    private Button insert;
   private Spinner spinner;
    public static Todo todoItem;
    private Button update;
    private Button delete;
    private  Button notification;
    public  static  String value_spinner="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
       // c_middlee.setEnabled(false);
        initView();
        if(todoItem!=null){
            insert.setVisibility(View.GONE);
            update.setVisibility(View.VISIBLE);
            delete.setVisibility(View.VISIBLE);
            c_name.setText(todoItem.getC_name());
            c_phone.setText(todoItem.getC_phone());
            c_dateTime.setText(todoItem.getDateTime());
            c_middle.setText(todoItem.getC_middle());
            c_value.setText(todoItem.getMoney());
            c_middlee.setText(todoItem.getT_pay());

        }

          notification.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  startActivity(new Intent(AddTodo.this,MainActivity.class));
              }
          });



          spinner.setOnItemSelectedListener(this);
        List<String>catago=new ArrayList<>();
        catago.add("قسط شهري");
        catago.add("قسط سنوي");
        catago.add("قسط ربغ سنوي");
        catago.add("قسط  نصف سنوي");
        ArrayAdapter<String>data=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,catago);
        data.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(data);


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDataBase.getDataBaseInstance(AddTodo.this)
                        .todoDao()
                        .DeleteTodo(todoItem);
                todoItem=null;

                finish();
            }
        });
    update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = c_name.getText().toString();
                String phone = c_phone.getText().toString();
                String sDate = c_dateTime.getText().toString();
                String middle  = c_middle.getText().toString();
                String value  = c_value.getText().toString();
                todoItem.setC_name(name);
                todoItem.setC_phone(phone);
                todoItem.setDateTime(sDate);
                todoItem.setC_middle(middle);
                todoItem.setMoney(value);
                todoItem.setT_pay(value_spinner);
                MyDataBase.getDataBaseInstance(AddTodo.this)
                        .todoDao()
                        .UpdateTodo(todoItem);
                todoItem=null;

                finish();
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = c_name.getText().toString();
                String phone = c_phone.getText().toString();
                String sDate = c_dateTime.getText().toString();
                String middle  = c_middle.getText().toString();
                String value = c_value.getText().toString();
                String sp=c_middlee.getText().toString();
                String data=getIntent().getStringExtra("data");

                Todo todo = new Todo(name, phone,middle,value ,sp,sDate);
                MyDataBase.getDataBaseInstance(AddTodo.this)
                        .todoDao().InsertTodo(todo);
                  item=  MyDataBase.getDataBaseInstance(AddTodo.this)
                          .todoDao()
                          .SelectAllTodo();


                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        todoItem = null;
    }

    private void initView() {
        c_name = (EditText) findViewById(R.id.title);
        c_phone = (EditText) findViewById(R.id.content);
        c_dateTime = (EditText) findViewById(R.id.date_time);
        c_middle = (EditText) findViewById(R.id.c_middle);
        c_value = (EditText) findViewById(R.id.c_value);
        c_middlee = (EditText) findViewById(R.id.c_middlee);
        insert = (Button) findViewById(R.id.insert);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        spinner = (Spinner) findViewById(R.id.spinner);
        notification=(Button) findViewById(R.id.notification);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        value_spinner=parent.getItemAtPosition(position).toString();
        c_middlee.setText( value_spinner);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
