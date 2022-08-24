package com.svalero.aa2pmdmrecu.contract;

import android.content.Context;

import com.svalero.aa2pmdmrecu.domain.Car;
import com.svalero.aa2pmdmrecu.domain.User;

import java.util.List;

public interface AddCarContract {



    interface Model {
        // USERS
        interface OnLoadUsersListener {
            void onLoadUsersSuccess(List<User> users);

            void onLoadUsersError(String message);
        }

        // COMPUTERS
        interface OnAddCarListener {
            void onAddCarSuccess(String message);

            void onAddCarError(String message);
        }

        interface OnModifyCarListener {
            void onModifyCarSuccess(String message);

            void onModifyCarError(String message);
        }

        void startDb(Context context);

        void addCar(OnAddCarListener listener, Car car);

        void modifyCar(OnModifyCarListener listener, Car car);

        void loadAllUser(OnLoadUsersListener listener);
    }

    interface View {
        void loadUserSpinner(List<User> users);

        void addCar(android.view.View view);

        void cleanForm();

        void showMessage(String message);
    }

    interface Presenter {
        void loadUsersSpinner();

        void addOrModifyCar(Car car, Boolean modifyCar);
    }












}
