package com.svalero.aa2pmdmrecu.contract;

import android.content.Context;

import com.svalero.aa2pmdmrecu.domain.Car;

import java.util.List;

public interface CarListContract {





    interface Model {
        interface OnLoadCarsListener {
            void onLoadCarsSuccess(List<Car> cars);

            void onLoadCarsError(String message);
        }

        interface OnDeleteCarListener{
            void onDeleteCarSuccess(String message);

            void onDeleteCarError(String message);
        }

        void startDb(Context context);

        void loadAllCars(OnLoadCarsListener listener);

        void loadCarsByBrand(OnLoadCarsListener listener, String query);

        void loadCarsByModel(OnLoadCarsListener listener, String query);

        void loadCarsByHorsePower(OnLoadCarsListener listener, String query);

        void delete(OnDeleteCarListener listener, Car car);
    }

    interface View {
        void listCars(List<Car> cars);

        void showMessage(String message);
    }

    interface Presenter {
        void loadAllCars();

        void loadCarsByBrand(String query);

        void loadCarsByModel(String query);

        void loadCarsByHorsePower(String query);

        void deleteCar(Car car);
    }






}
