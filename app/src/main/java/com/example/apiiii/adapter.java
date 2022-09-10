package com.example.apiiii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class adapter extends BaseAdapter {
    String names[];
    String phones[];
    Context cm;

    adapter(String x[], Context c){
        names = x;
        cm = c;
    }
    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(cm).inflate(R.layout.ll, parent, false);
        TextView x = convertView.findViewById(R.id.txt1);
        x.setText(names[position]);
        return convertView;
    }
}
