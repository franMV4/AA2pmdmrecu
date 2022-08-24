package com.svalero.aa2pmdmrecu.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.svalero.aa2pmdmrecu.R;
import com.svalero.aa2pmdmrecu.domain.dto.ReparationDTOAdapter;

import java.util.ArrayList;
import java.util.Base64;

public class ReparationAdapter extends BaseAdapter {






    private Context context;
    private ArrayList<ReparationDTOAdapter> reparationArrayList;
    private LayoutInflater inflater;

    public ReparationAdapter(Activity context, ArrayList<ReparationDTOAdapter> reparationArrayList) {
        this.context = context;
        this.reparationArrayList = reparationArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ReparationDTOAdapter reparationDTOAdapter = (ReparationDTOAdapter) getItem(position);

        convertView = inflater.inflate(R.layout.user_and_car_adapter, null);
        TextView reparationDateAndComputerModel = convertView.findViewById(R.id.user_car_tv1);
        TextView reparationHorsePowerAndRepairedPart = convertView.findViewById(R.id.user_car_tv2);

        reparationDateAndComputerModel.setTextSize(22);
        reparationHorsePowerAndRepairedPart.setTextSize(18);


        reparationDateAndComputerModel.setText(reparationDTOAdapter.getDateOfDelivery() + " || " + reparationDTOAdapter.getCarBrandModel());
        reparationHorsePowerAndRepairedPart.setText(reparationDTOAdapter.getCarHorsePower() + " || " + reparationDTOAdapter.getRepairedPart());

        return convertView;
    }

    @Override
    public int getCount() {
        return reparationArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return reparationArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




}
