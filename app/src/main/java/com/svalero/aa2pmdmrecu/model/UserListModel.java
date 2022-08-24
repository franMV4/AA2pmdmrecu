package com.svalero.aa2pmdmrecu.model;

import android.content.Context;

import androidx.room.Room;

import com.svalero.aa2pmdmrecu.api.AA2PmdmRecuInterface;
import com.svalero.aa2pmdmrecu.api.Aa2PmdmRecuApi;
import com.svalero.aa2pmdmrecu.contract.UserListContract;
import com.svalero.aa2pmdmrecu.database.AppDatabase;
import com.svalero.aa2pmdmrecu.domain.User;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListModel implements UserListContract.Model {

    private AppDatabase db;
    private AA2PmdmRecuInterface api;
    private List<User> users;

    @Override
    public void startDb(Context context) {
        users = new ArrayList<>();
        api = Aa2PmdmRecuApi.buildInstance();
        db = Room.databaseBuilder(context,
                AppDatabase.class, "user").allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
    }

    @Override
    public void loadAllUsers(OnLoadUsersListener listener) {
        users.clear();

        Call<List<User>> userCall = api.getUsers();

        loadUsersCallEnqueue(listener, userCall);
    }

    @Override
    public void loadUsersByName(OnLoadUsersListener listener, String query) {
        users.clear();

        Call<List<User>> userCall = api.getUsersByName(query);

        loadUsersCallEnqueue(listener, userCall);
    }

    @Override
    public void loadUsersBySurname(OnLoadUsersListener listener, String query) {
        users.clear();

        Call<List<User>> userCall = api.getUsersBySurname(query);

        loadUsersCallEnqueue(listener, userCall);
    }

    @Override
    public void loadUsersByDni(OnLoadUsersListener listener, String query) {
        users.clear();

        Call<List<User>> userCall = api.getUsersByDni(query);

        loadUsersCallEnqueue(listener, userCall);
    }

    /**
     * Envía la solicitud de forma asíncrona y notifica la devolución de llamada de su respuesta
     * o si se produjo un error al hablar con el servidor, crear la solicitud o procesar la respuesta.
     *
     * @param listener OnLoadComputersListener
     * @param call     Lista de Computers
     */
    private void loadUsersCallEnqueue(OnLoadUsersListener listener, Call<List<User>> call) {
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users = response.body();
                listener.onLoadUsersSuccess(users);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                listener.onLoadUsersError("Se ha producido un error");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void deleteUser(OnDeleteUserListener listener, User user) {
        api.deleteUsers(user.getId()).enqueue(new Callback<Void>() {

       // Call<Void> userCall = api.deleteUsers(user.getId());
        //userCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                listener.onDeleteUserSuccess("Usuario eliminado correctamente");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onDeleteUserError("No se ha podido eliminar el usuario");
                t.printStackTrace();
            }
        });
    }
}
