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
import com.svalero.aa2pmdmrecu.domain.Car;
import com.svalero.aa2pmdmrecu.util.ImageUtils;

import java.util.Base64;
import java.util.List;

public class CarAdapter extends BaseAdapter {

    private Context context;
    private List<Car> carArrayList;
    private LayoutInflater inflater;



    public CarAdapter(Activity context, List<Car> carArrayList) {
        this.context = context;
        this.carArrayList = carArrayList;
        inflater = LayoutInflater.from(context);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Car car = (Car) getItem(position);

        convertView = inflater.inflate(R.layout.user_and_car_adapter, null);
        TextView carmodel = convertView.findViewById(R.id.user_car_tv1);
        TextView carHorsePower = convertView.findViewById(R.id.user_car_tv2);



        carmodel.setText(car.getBrand() + " " + car.getModel());
        carHorsePower.setText(car.getHorsePower());

        return convertView;
    }




    @Override
    public int getCount() {
        return carArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return carArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}





