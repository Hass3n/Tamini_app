package com.example.hassan.todolist.ToDolist.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.hassan.todolist.R;
import com.example.hassan.todolist.ToDolist.DataBase.Model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.ViewHolder>{

    List<Todo> items;
   public static List<Todo>filteitem;
    Context context;
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public TodosAdapter(List<Todo> items, Context context) {
        this.items = items;
        this.context = context;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Todo todo = items.get(position);
        holder.name.setText("اسم العميل:"+todo.getC_name());
        holder.phone.setText(  "تليفون العميل:"+ todo.getC_phone());
        holder.data.setText( "تاريخ التعاقد:"+  todo.getDateTime());
        holder.middle.setText("اسم الوسيط:"+ todo.getC_middle());
        holder.value.setText("قيمة القسط:"+  todo.getMoney());
        holder.pay.setText("نوع القسط:  "+todo.getT_pay());
        if(onItemClickListener!=null)
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(position,todo);
                }
            });
    }

   public void setDate(List<Todo> items){
        this.items= items;
       this.filteitem=new ArrayList<Todo>();
       // this.filteitem=items;
       this.filteitem.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(items==null)return 0;
        return items.size();
    }

    public void filter(String chatext)
    {

        chatext=chatext.toLowerCase(Locale.getDefault());
        items.clear();
        if (chatext.length()==0)
        {
            items.addAll(filteitem);
        }else {
            for (Todo wp:filteitem)
            {
                if (wp.getC_name().toLowerCase(Locale.getDefault()).contains(chatext))
                {
                    items.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,phone,data,middle,value,pay;


        View parent;
        ViewHolder(View view){
            super(view);
            parent=view;
            name= view.findViewById(R.id.title);
            data = view.findViewById(R.id.date_time);
            phone = view.findViewById(R.id.c_phone);
            middle = view.findViewById(R.id.c_middle);
            value= view.findViewById(R.id.c_money);
            pay= view.findViewById(R.id.c_pay);

        }


    }

    public interface OnItemClickListener{
        void onClick(int pos, Todo item);
    }
}
