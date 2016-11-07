package com.chen.example.learnhellochart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;

/**
 * A fragment containing a pie chart.
 */
public class PieChartFragment extends Fragment {

    private PieChartView chart;
    private PieChartData data;

    public PieChartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        chart = (PieChartView) rootView.findViewById(R.id.chart);
        chart.setChartRotationEnabled(true);
        int num = 3;
        float[] dataValue = {12f,19f,69f};
        int[] colors = {ChartUtils.COLOR_RED, ChartUtils.COLOR_GREEN, ChartUtils.COLOR_BLUE};
        generateData(num,dataValue,colors);
        return rootView;
    }

    private void generateData(int num,float[] dataValue,int[] colors) {

        List<SliceValue> values = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            SliceValue sliceValue = new SliceValue(dataValue[i], colors[i]);
            values.add(sliceValue);
        }
        data = new PieChartData(values);
        data.setHasCenterCircle(true);
        data.setCenterText1(String.valueOf(dataValue[2]) + "%");
        data.setCenterText1FontSize(ChartUtils.px2sp(getResources().getDisplayMetrics().scaledDensity,
                (int) getResources().getDimension(R.dimen.pie_chart_text1_size)));
        chart.setPieChartData(data);
    }
}
