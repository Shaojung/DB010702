package com.example.student.db010702;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinner, spinner2;
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



    }
    public void click1(View v)
    {
        int p = spinner.getSelectedItemPosition();
        String data[] = getResources().getStringArray(R.array.cities);
        tv2.setText(data[p]);
    }
}
