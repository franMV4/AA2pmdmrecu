package com.svalero.aa2pmdmrecu.model;

import android.content.Context;

import androidx.room.Room;

import com.svalero.aa2pmdmrecu.api.AA2PmdmRecuInterface;
import com.svalero.aa2pmdmrecu.api.Aa2PmdmRecuApi;
import com.svalero.aa2pmdmrecu.contract.AddCarContract;
import com.svalero.aa2pmdmrecu.database.AppDatabase;
import com.svalero.aa2pmdmrecu.domain.Car;
import com.svalero.aa2pmdmrecu.domain.User;
import com.svalero.aa2pmdmrecu.domain.dto.CarDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCarModel implements AddCarContract.Model {




    private AppDatabase db;
    private AA2PmdmRecuInterface api;
    private List<User> users;

    @Override
    public void startDb(Context context) {
        users = new ArrayList<>();
        api = Aa2PmdmRecuApi.buildInstance();
        db = Room.databaseBuilder(context,
                        AppDatabase.class, "car").allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
    }

    @Override
    public void addCar(OnAddCarListener listener, Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setColor(car.getColor());
        carDTO.setHorsePower(car.getHorsePower());
        carDTO.setUser(car.getUser().getId());

        Call<Car> carCall = api.addCar(carDTO);

        carCall.enqueue(new Callback<Car>() {
            @Override
            public void onResponse(Call<Car> call, Response<Car> response) {
                listener.onAddCarSuccess("Coche añadido con éxito");
            }

            @Override
            public void onFailure(Call<Car> call, Throwable t) {
                listener.onAddCarError("No se ha podido añadir el coche");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void modifyCar(OnModifyCarListener listener, Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setColor(car.getColor());
        carDTO.setHorsePower(car.getHorsePower());
        carDTO.setUser(car.getUser().getId());

        Call<Car> carCall = api.modifyCar(car.getId(), carDTO);

        carCall.enqueue(new Callback<Car>() {
            @Override
            public void onResponse(Call<Car> call, Response<Car> response) {
                listener.onModifyCarSuccess("Coche modificado con éxito");
            }

            @Override
            public void onFailure(Call<Car> call, Throwable t) {
                listener.onModifyCarError("No se ha podido modificar el coche");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void loadAllUser(OnLoadUsersListener listener) {
        users.clear();

        Call<List<User>> userCall = api.getUsers();

        userCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users = response.body();
                listener.onLoadUsersSuccess(users);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                listener.onLoadUsersError("Se ha producido un error");
            }
        });
    }
}


























