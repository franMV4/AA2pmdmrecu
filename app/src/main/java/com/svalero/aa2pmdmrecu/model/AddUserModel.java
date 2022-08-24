package com.svalero.aa2pmdmrecu.model;

import android.content.Context;
import android.os.StrictMode;

import androidx.room.Room;

import com.svalero.aa2pmdmrecu.api.AA2PmdmRecuInterface;
import com.svalero.aa2pmdmrecu.api.Aa2PmdmRecuApi;
import com.svalero.aa2pmdmrecu.contract.AddUserContract;
import com.svalero.aa2pmdmrecu.database.AppDatabase;
import com.svalero.aa2pmdmrecu.domain.User;
import com.svalero.aa2pmdmrecu.view.AddUserView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserModel implements AddUserContract.Model {

    private AppDatabase db;
    private AA2PmdmRecuInterface api;

    @Override
    public void startDb(Context context) {
        api = Aa2PmdmRecuApi.buildInstance();
        db = Room.databaseBuilder(context,
                        AppDatabase.class, "user").allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
    }

    @Override
    public void addUser(OnAddUserListener onAddUserListener, User user) {

        Call<User> userCall = api.addUser(user);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                onAddUserListener.onAddUserSuccess("Usuario añadido correctamente");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                onAddUserListener.onAddUserError("No se ha podido añadir el usuario");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void modifyUser(OnModifyUserListener onModifyUserListener, User user) {

        Call<User> userCall = api.modifyUser(user.getId(), user);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                onModifyUserListener.onModifyUserSuccess("Usuario modificado con éxito");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                onModifyUserListener.onModifyUserError("No se ha podido modificar");
                t.printStackTrace();
            }
        });
    }
}

