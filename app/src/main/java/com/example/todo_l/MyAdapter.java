package com.example.todo_l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends BaseAdapter {
    ArrayList lv;
    Context context;


    public MyAdapter(ArrayList data, Context context) {
        this.lv = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lv.size();
    }

    @Override
    public Object getItem(int i) {
        return lv.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view01, ViewGroup viewGrop) {
        if (view01 == null) {
            view01 = LayoutInflater.from(context)
                    .inflate(R.layout.line_list, null);}
            TextView langueNom = view01.findViewById(R.id.tatile);
            TextView languetest = view01.findViewById(R.id.test);
            TextView languedate = view01.findViewById(R.id.date);
        ImageButton edait = (ImageButton) view01.findViewById(R.id.in3);
        ImageButton delate = (ImageButton) view01.findViewById(R.id.in4);
            HashMap<String, String> hm = (HashMap<String, String>) lv.get(i);
            languetest.setText(hm.get("description"));
            langueNom.setText(hm.get("nom"));
            languedate.setText(hm.get("endDate"));
       /* edait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "trueee", Toast.LENGTH_SHORT).show();
                hm.remove(position);
                notifyDataSetChanged();

            }   });*/
        delate.setVisibility(View.INVISIBLE);
    /*OnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "trueee", Toast.LENGTH_SHORT).show();
          lv.remove(i);
       Stoctaks.dremove(i);
                    notifyDataSetChanged();
                }

        });
*/

        return view01;
    }
}