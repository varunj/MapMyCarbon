package com.google.android.gms.location.sample.activityrecognition;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TabFragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my, container, false);
        RecyclerView recList = (RecyclerView) view.findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        LogsAdapter ca = new LogsAdapter(createList(30));
        recList.setAdapter(ca);
        return view;
    }
    private List<LogsInfo> createList(int size) {

        List<LogsInfo> result = new ArrayList<LogsInfo>();
//        for (int i=1; i <= size; i++) {
//            LogsInfo ci = new LogsInfo();
//            ci.Carbon_FootPrint = "4522.72 gm";
//            ci.Activity = "Car";
//            ci.Distance = "44.95 km";
//            ci.Date = "2016-04-01";
//            result.add(ci);
//
//        }
        LogsInfo ci = new LogsInfo();
        ci.Carbon_FootPrint = "4522.72"; ci.Activity = "Car"; ci.Distance = "44.95"; ci.Date = "2016-04-01";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4398.4"; ci.Activity = "Car"; ci.Distance = "43.83"; ci.Date = "2016-04-02";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4594.8"; ci.Activity = "Car"; ci.Distance = "45.42"; ci.Date = "2016-04-03";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4328.64"; ci.Activity = "Car"; ci.Distance = "43.15"; ci.Date = "2016-04-04";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4523.64"; ci.Activity = "Car"; ci.Distance = "44.44"; ci.Date = "2016-04-05";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "1569.48"; ci.Activity = "Car"; ci.Distance = "15.62"; ci.Date = "2016-04-06";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "1766.2"; ci.Activity = "Car"; ci.Distance = "17.2"; ci.Date = "2016-04-07";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4559.36"; ci.Activity = "Car"; ci.Distance = "44.52"; ci.Date = "2016-04-08";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4578.2"; ci.Activity = "Car"; ci.Distance = "45.21"; ci.Date = "2016-04-09";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4496.48"; ci.Activity = "Car"; ci.Distance = "44.67"; ci.Date = "2016-04-10";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4434.32"; ci.Activity = "Car"; ci.Distance = "43.56"; ci.Date = "2016-04-11";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4715.16"; ci.Activity = "Car"; ci.Distance = "45.88"; ci.Date = "2016-04-12";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "1789.16"; ci.Activity = "Car"; ci.Distance = "17.72"; ci.Date = "2016-04-13";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "1809.28"; ci.Activity = "Car"; ci.Distance = "17.6"; ci.Date = "2016-04-14";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4464.2"; ci.Activity = "Car"; ci.Distance = "44.51"; ci.Date = "2016-04-15";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4659.08"; ci.Activity = "Car"; ci.Distance = "45.9"; ci.Date = "2016-04-16";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4451.48"; ci.Activity = "Car"; ci.Distance = "43.67"; ci.Date = "2016-04-17";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4713.68"; ci.Activity = "Car"; ci.Distance = "45.83"; ci.Date = "2016-04-18";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4412.56"; ci.Activity = "Car"; ci.Distance = "43.47"; ci.Date = "2016-04-19";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "1789.0"; ci.Activity = "Car"; ci.Distance = "17.78"; ci.Date = "2016-04-20";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "1867.56"; ci.Activity = "Car"; ci.Distance = "18.57"; ci.Date = "2016-04-21";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4569.32"; ci.Activity = "Car"; ci.Distance = "45.13"; ci.Date = "2016-04-22";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4565.92"; ci.Activity = "Car"; ci.Distance = "44.37"; ci.Date = "2016-04-23";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4346.4"; ci.Activity = "Car"; ci.Distance = "43.42"; ci.Date = "2016-04-24";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4543.84"; ci.Activity = "Car"; ci.Distance = "44.95"; ci.Date = "2016-04-25";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4512.08"; ci.Activity = "Car"; ci.Distance = "44.98"; ci.Date = "2016-04-26";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4440.2"; ci.Activity = "Car"; ci.Distance = "43.61"; ci.Date = "2016-04-27";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "4401.84"; ci.Activity = "Car"; ci.Distance = "43.97"; ci.Date = "2016-04-28";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "1770.76"; ci.Activity = "Car"; ci.Distance = "17.03"; ci.Date = "2016-04-29";
        result.add(ci);
        ci = new LogsInfo();
        ci.Carbon_FootPrint = "1830.36"; ci.Activity = "Car"; ci.Distance = "18.22"; ci.Date = "2016-04-30";
        result.add(ci);
        return result;
    }
}