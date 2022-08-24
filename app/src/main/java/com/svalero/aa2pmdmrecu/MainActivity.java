package com.svalero.aa2pmdmrecu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.svalero.aa2pmdmrecu.view.AddCarView;
import com.svalero.aa2pmdmrecu.view.AddUserView;
import com.svalero.aa2pmdmrecu.view.CarListView;
import com.svalero.aa2pmdmrecu.view.UserListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void addCar(View view) {
        Intent intent = new Intent(this, AddCarView.class);
        startActivity(intent);
    }

    public void viewCar(View view) {
        Intent intent = new Intent(this, CarListView.class);
        startActivity(intent);
    }

    public void addUser(View view) {
        Intent intent = new Intent(this, AddUserView.class);
        startActivity(intent);
    }

    public void viewUser(View view) {
        Intent intent = new Intent(this, UserListView.class);
        startActivity(intent);
    }




}



