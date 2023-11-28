package com.example.todo_l.Ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.todo_l.Module.Task;
import com.example.todo_l.MyAdaper_2;
import com.example.todo_l.MyAdapter;
import com.example.todo_l.Module.Proprieter;
import com.example.todo_l.R;
import com.example.todo_l.Stoctaks;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   List<Task> taskList = new ArrayList<>();
RecyclerView lv;
    FloatingActionButton fbtn;
    Intent intent;
    List<HashMap<String, String>> list=new ArrayList<>();
    MyAdaper_2 a;
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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        convertTaskListToHashMapList(Stoctaks.taskList);
       a = new MyAdaper_2((ArrayList) list, this);
        lv.setAdapter(a);
        fbtn = findViewById(R.id.fab);
        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
          intent = new Intent(MainActivity.this, view_task.class);
                startActivity(intent);
            }
        });
    }
    /////////////////////////menu////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mennu, menu);


        MenuItem.OnActionExpandListener listener = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(@NonNull MenuItem menuItem) {

                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(@NonNull MenuItem menuItem) {

                return true;
            }
        };
        Spinner spinner = (Spinner) menu.findItem(R.id.spine).getActionView();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Proprieter.getStringValues());
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                              @Override
                                              public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                                                  list.clear();

                                                  String selectedValue = spinner.getSelectedItem().toString();
                                                  ArrayList<Task> filteredTasks = Stoctaks.search(selectedValue);


                                                  list.addAll(convertTaskListToHashMapList(filteredTasks));


                                                  a.notifyDataSetChanged();
                                              }


 @Override
 public void onNothingSelected(AdapterView<?> parentView) {
  }
     });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {
        switch  (menu.getItemId()) {
            case R.id.list:
                intent =new Intent(MainActivity.this, list_delate.class);
                startActivity(intent);
                return true;
            case R.id.about:
                Toast.makeText(this, "Option Save sélectionnée",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.spine:
                list.clear();

                Toast.makeText(this, "Option Supprimer sélectionnée",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings:

                Toast.makeText(this, "Option Aide sélectionnée",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected( menu);
        }

    }
}