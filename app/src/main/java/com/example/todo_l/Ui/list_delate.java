package com.example.todo_l.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.example.todo_l.Module.Task;
import com.example.todo_l.MyAdapter;
import com.example.todo_l.R;
import com.example.todo_l.Stoctaks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class list_delate extends AppCompatActivity {
ListView lv;
    List<HashMap<String, String>> list=new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_delate);
        lv=findViewById(R.id.lvd);
        MyAdapter a = new MyAdapter((ArrayList) convertTaskListToHashMapList(Stoctaks.delitList), this);
        lv.setAdapter(a);

    }
    private List<HashMap<String, String>> convertTaskListToHashMapList(ArrayList<Task> task) {
        for (Task t:task) {
            HashMap<String, String> taskMap = new HashMap<>();
            taskMap.put("nom", t.getTitre());
            taskMap.put("description", t.getDescription());
            taskMap.put("endDate", String.valueOf(t.getDate_fin()));
            list.add(taskMap);

        }
        return list;
    }

}