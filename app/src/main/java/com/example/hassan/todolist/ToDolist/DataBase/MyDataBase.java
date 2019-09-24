package com.example.hassan.todolist.ToDolist.DataBase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.hassan.todolist.ToDolist.DataBase.Model.Todo;


@Database(entities = {Todo.class},version = 2,exportSchema = false)

public abstract class MyDataBase extends RoomDatabase {

    /*static Migration migration_1_2=new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Todo" +"ADD COLUMN name TEXT");
        }
    };*/
    private static MyDataBase dataBaseInstance;

    public abstract TodoDao todoDao();


    public static MyDataBase getDataBaseInstance(Context context) {
        if(dataBaseInstance == null){
            //create database instance
          dataBaseInstance=  Room.databaseBuilder(context.getApplicationContext(),
                    MyDataBase.class, "Todo_DB")
                  .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                     .build(); // SHOULD NOT
        }

        return dataBaseInstance;
    }
}
