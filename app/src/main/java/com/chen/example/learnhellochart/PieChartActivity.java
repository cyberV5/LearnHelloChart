package com.chen.example.learnhellochart;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class PieChartActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PieChartFragment()).commit();
        }
    }

}
