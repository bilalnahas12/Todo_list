package com.example.todo_l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo_l.Module.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyAdaper_2 extends RecyclerView.Adapter<MyAdaper_2.MyViewHolder> {
    ArrayList list;
    Context context;
    boolean hide;
    public MyAdaper_2(ArrayList list, Context context) {
        this.list = list;
        this.context = context;
        this.hide = false;
    }
    public MyAdaper_2(ArrayList list, Context context,boolean hide) {
        this.list = list;
        this.context = context;
        this.hide = hide;
    }
    public void setTaskList(ArrayList taskList) {
        this.list = taskList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.line_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        HashMap<String, String> hm = (HashMap<String, String>) list.get(position);
        holder.languetext.setText(hm.get("description"));
        holder.langueNom.setText(hm.get("nom"));
        holder.languedate.setText(hm.get("endDate"));
        if(hide){
            holder.delate.setVisibility(View.INVISIBLE);
        }else {

        holder.delate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "trueee", Toast.LENGTH_SHORT).show();
                Stoctaks.dremove(position);
                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }}

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView langueNom, languetext, languedate;
        ImageButton edait, delate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            langueNom = itemView.findViewById(R.id.tatile);
            languetext = itemView.findViewById(R.id.test);
            languedate = itemView.findViewById(R.id.date);
            edait = (ImageButton) itemView.findViewById(R.id.in3);
            delate = (ImageButton) itemView.findViewById(R.id.in4);
        }
    }
}
