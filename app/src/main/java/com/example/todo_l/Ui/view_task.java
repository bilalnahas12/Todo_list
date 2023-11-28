package com.example.todo_l.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.todo_l.Module.Task;
import com.example.todo_l.Module.Proprieter;
import com.example.todo_l.R;
import com.example.todo_l.Stoctaks;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class view_task extends AppCompatActivity {
    EditText titale, tit, date_init, date_fin;
    ImageButton ibtn, ibtn2;
    Spinner spinner;
    FloatingActionButton fbtn;
    Task task;
ArrayList<Task> tasks=new ArrayList<Task>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);
        Intent intent = getIntent();
        ArrayList receivedTask = (ArrayList) intent.getSerializableExtra("task");
        final Calendar c = Calendar.getInstance();
        final int year = c.get(Calendar.YEAR);
        final int month = c.get(Calendar.MONTH);
        final int day = c.get(Calendar.DAY_OF_MONTH);
        titale = findViewById(R.id.titale);
        tit = findViewById(R.id.description);
        date_init = findViewById(R.id.date_init);
        date_fin = findViewById(R.id.date_fin);
        ibtn = findViewById(R.id.imageButton);
        ibtn2 = findViewById(R.id.imageButton2);
        spinner = findViewById(R.id.spinner);
        fbtn = findViewById(R.id.fab);
        ArrayAdapter<String> priorityAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                Proprieter.getStringValues()
        );
        spinner.setAdapter(priorityAdapter);
        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = new DatePickerDialog(view_task.this,R.style.DialogTheme,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int myear, int monthOfYear, int dayOfMonth) {
                                date_init.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + myear);
                            }
                        }, year, month, day);
                dpd.show();

            }
        }); ibtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = new DatePickerDialog(view_task.this,R.style.DialogTheme,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int myear, int monthOfYear, int dayOfMonth) {
                                date_fin.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + myear);
                            }
                        }, year, month, day);
                dpd.show();

            }
        });

        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isAnyFieldEmpty(titale, tit, date_init, date_fin) || !isSpinnerItemSelected(spinner)) {
                    showToast("Please fill in all fields and select an item from the Spinner.");
                } else {
                    Proprieter selectedPriority = Proprieter.valueOf(spinner.getSelectedItem().toString());



                    task= new Task(
                            titale.getText().toString(),
                            tit.getText().toString(),
                            getDateFromString(date_init.getText().toString()),
                            getDateFromString(date_fin.getText().toString()),
                            selectedPriority
                    );

                   Stoctaks.add(task);
                    showToast("All fields are filled. Performing your action.");
                    Intent intent = new Intent(view_task.this, MainActivity.class);
                    startActivity(intent);



                }
            }
        });

    }

    private Date getDateFromString(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            showToast("Error parsing date");
            return null;
        }
    }

    private boolean isAnyFieldEmpty(EditText... editTexts) {
        for (EditText editText : editTexts) {
            if (editText.getText() == null || editText.getText().toString().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private boolean isSpinnerItemSelected(Spinner spinner) {
        return spinner.getSelectedItem() != null;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
