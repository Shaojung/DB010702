package com.example.student.db010702;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Spinner spinner, spinner2, spinner3;
    TextView tv, tv2;
    String[] fruits = {"蘋果","橘子", "柳丁", "香蕉"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // tv.setText(String.valueOf(position));

                // TextView tv2 = (TextView) view;
                // tv.setText(tv2.getText());

                String data[] = getResources().getStringArray(R.array.cities);
                tv.setText(data[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                android.R.layout.simple_spinner_item,
                                fruits);
        spinner2.setAdapter(adapter);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayList<Map<String, String>> mylist = new ArrayList<>();
        HashMap<String, String> m1 = new HashMap<>();
        m1.put("city", "台北");
        m1.put("code", "02");
        mylist.add(m1);
        HashMap<String, String> m2 = new HashMap<>();
        m2.put("city", "台中");
        m2.put("code", "04");
        mylist.add(m2);
        HashMap<String, String> m3 = new HashMap<>();
        m3.put("city", "高雄");
        m3.put("code", "07");
        mylist.add(m3);

        SimpleAdapter sa = new SimpleAdapter(this,
                        mylist,
                        android.R.layout.simple_list_item_2,
                        new String[] {"city", "code"},
                        new int[] {android.R.id.text1, android.R.id.text2});
        spinner3.setAdapter(sa);


    }
    public void click1(View v)
    {
        int p = spinner.getSelectedItemPosition();
        String data[] = getResources().getStringArray(R.array.cities);
        tv2.setText(data[p]);
    }
}
