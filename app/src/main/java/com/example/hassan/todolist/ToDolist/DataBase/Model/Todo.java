package com.example.hassan.todolist.ToDolist.DataBase.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity

public class Todo {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo
    String c_name;
    @ColumnInfo
    String c_phone;
    @ColumnInfo
    String c_middle;
    @ColumnInfo
    String money;
    @ColumnInfo
    String t_pay;
    @ColumnInfo
    String dateTime;
     public Todo()
     {

     }
     @Ignore
    public Todo(String c_name, String c_phone, String c_middle, String money, String t_pay, String dateTime) {
        this.c_name = c_name;
        this.c_phone = c_phone;
        this.c_middle = c_middle;
        this.money = money;
        this.t_pay = t_pay;
        this.dateTime = dateTime;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_phone() {
        return c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    public String getC_middle() {
        return c_middle;
    }

    public void setC_middle(String c_middle) {
        this.c_middle = c_middle;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getT_pay() {
        return t_pay;
    }

    public void setT_pay(String t_pay) {
        this.t_pay = t_pay;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
