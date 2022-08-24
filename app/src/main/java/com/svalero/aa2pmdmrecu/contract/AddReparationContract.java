package com.svalero.aa2pmdmrecu.contract;

import android.content.Context;

import com.svalero.aa2pmdmrecu.domain.Car;
import com.svalero.aa2pmdmrecu.domain.Reparation;
import com.svalero.aa2pmdmrecu.domain.User;

import java.util.List;

public interface AddReparationContract {



    interface Model {
        // USERS
        interface OnLoadUsersListener {
            void onLoadUsersSuccess(List<User> users);

            void onLoadUsersError(String message);
        }

        // COMPUTERS
        interface OnLoadCarsListener {
            void onLoadCarsSuccess(List<Car> usersCar);

            void onLoadCarsError(String message);
        }

        // ORDERS
        interface OnAddReparationListener {
            void onAddReparationSuccess(String message);

            void onAddReparationError(String message);
        }

        interface OnModifyReparationListener {
            void onModifyReparationSuccess(String message);

            void onModifyReparationError(String message);
        }

        void startDb(Context context);

        void loadAllUser(OnLoadUsersListener listener);

        void loadUserCars(OnLoadCarsListener listener, User user);

        void addReparation(OnAddReparationListener listener, Reparation reparation);

        void modifyReparation(OnModifyReparationListener listener, Reparation reparation);
    }

    interface View {
        void loadUserSpinner(List<User> users);

        void loadUserCarSpinner(List<Car> cars);

        void addCar(android.view.View view);

        void cleanForm();

        void showMessage(String message);
    }

    interface Presenter {
        void loadUsersSpinner();

        void loadUserComputerSpinner(User user);

        void addOrModifyOrder(Reparation reparation, Boolean modifyReparation);
    }






}
