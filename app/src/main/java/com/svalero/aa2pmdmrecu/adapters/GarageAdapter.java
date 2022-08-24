package com.svalero.aa2pmdmrecu.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.svalero.aa2pmdmrecu.R;
import com.svalero.aa2pmdmrecu.domain.Garage;

import java.util.Base64;
import java.util.List;

public class GarageAdapter //extends BaseAdapter
 {


/*
    private Context context;
    private List<Garage> garageArrayList;
    private LayoutInflater inflater;

    public GarageAdapter(Activity context, List<Garage> c) {
        this.context = context;
        this.garageArrayList = garageArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Garage garage = (Garage) getItem(position);

        convertView = inflater.inflate(R.layout.garage_and_car_adapter, null);
        TextView userNameAndSurnameTv = convertView.findViewById(R.id.garage_car_tv1);
        TextView userDniTv = convertView.findViewById(R.id.garage_car_tv2);


        userNameAndSurnameTv.setText(garage.getCity() + " " + garage.getStreet());
        userDniTv.setText(garage.getCapacity());

        return convertView;
    }

    @Override
    public int getCount() {
        return garageArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return garageArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }*/
}


