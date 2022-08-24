package com.svalero.aa2pmdmrecu.model;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.svalero.aa2pmdmrecu.api.AA2PmdmRecuInterface;
import com.svalero.aa2pmdmrecu.api.Aa2PmdmRecuApi;
import com.svalero.aa2pmdmrecu.contract.AddReparationContract;
import com.svalero.aa2pmdmrecu.database.AppDatabase;
import com.svalero.aa2pmdmrecu.domain.Car;
import com.svalero.aa2pmdmrecu.domain.Reparation;
import com.svalero.aa2pmdmrecu.domain.User;
import com.svalero.aa2pmdmrecu.domain.dto.ReparationDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddReparationModel implements AddReparationContract.Model {






    private AppDatabase db;
    private AA2PmdmRecuInterface api;
    private List<User> users;
    private List<Car> userCar;

    @Override
    public void startDb(Context context) {
        users = new ArrayList<>();
        userCar=new ArrayList<>();
        api = Aa2PmdmRecuApi.buildInstance();
        db = Room.databaseBuilder(context,
                        AppDatabase.class, "reparation").allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
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

    @Override
    public void loadUserCars(OnLoadCarsListener listener, User user) {
        userCar.clear();
        Log.i("CAR", user.toString());
        Call<List<Car>> userCarCall = api.getCarsByUserId(user.getId());

        userCarCall.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                userCar = response.body();
                Log.i("CAR", userCar.toString());
                listener.onLoadCarsSuccess(userCar);
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                listener.onLoadCarsError("Se ha producido un error");
            }
        });
    }

    @Override
    public void addReparation(OnAddReparationListener listener, Reparation reparation) {
        ReparationDTO reparationDTO=new ReparationDTO();
        reparationDTO.setCost(reparation.getCost());
        reparationDTO.setDelivered(reparation.isDelivered());
        reparationDTO.setRepairedPart(reparation.getRepairedPart());
        reparationDTO.setDateOfDelivery(reparation.getDateOfDelivery());
        reparationDTO.setPickUpDate(reparation.getPickUpDate());
        reparationDTO.setNumeroMecanicos(reparation.getNumeroMecanicos());

        reparationDTO.setGarage(reparation.getGarage().getId());
        reparationDTO.setCar(reparation.getCar().getId());
        Log.i("CAR", "DTO" + reparationDTO);
        Call<Reparation> orderCall = api.addReparation(reparationDTO);

        orderCall.enqueue(new Callback<Reparation>() {
            @Override
            public void onResponse(Call<Reparation> call, Response<Reparation> response) {
                listener.onAddReparationSuccess("Reparacion añadida correctamente");
            }

            @Override
            public void onFailure(Call<Reparation> call, Throwable t) {
                listener.onAddReparationError("Error al añadir la reparacion");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void modifyReparation(OnModifyReparationListener listener, Reparation reparation) {
        ReparationDTO reparationDTO=new ReparationDTO();
        reparationDTO.setCost(reparation.getCost());
        reparationDTO.setDelivered(reparation.isDelivered());
        reparationDTO.setRepairedPart(reparation.getRepairedPart());
        reparationDTO.setDateOfDelivery(reparation.getDateOfDelivery());
        reparationDTO.setPickUpDate(reparation.getPickUpDate());
        reparationDTO.setNumeroMecanicos(reparation.getNumeroMecanicos());

        reparationDTO.setGarage(reparation.getGarage().getId());
        reparationDTO.setCar(reparation.getCar().getId());
        Log.i("CAR", "DTO" +reparationDTO);
        Call<Reparation> reparationCall = api.modifyReparation(reparation.getId(), reparationDTO);

        reparationCall.enqueue(new Callback<Reparation>() {
            @Override
            public void onResponse(Call<Reparation> call, Response<Reparation> response) {
                listener.onModifyReparationSuccess("Orden añadida correctamente");
            }

            @Override
            public void onFailure(Call<Reparation> call, Throwable t) {
                listener.onModifyReparationSuccess("Error al añadir la orden");
                t.printStackTrace();
            }
        });
    }









}
