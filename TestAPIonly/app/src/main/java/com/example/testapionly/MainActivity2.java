package com.example.testapionly;

import static com.example.testapionly.MainActivity.stations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tv=findViewById(R.id.textView2);
        tv.setText(stations.get(5));
    }
}