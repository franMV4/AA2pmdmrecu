package com.svalero.aa2pmdmrecu.presenter;

import com.svalero.aa2pmdmrecu.contract.CarListContract;
import com.svalero.aa2pmdmrecu.domain.Car;
import com.svalero.aa2pmdmrecu.model.CarListModel;
import com.svalero.aa2pmdmrecu.view.CarListView;


import java.util.List;

public class CarListPresenter implements CarListContract.Presenter, CarListContract.Model.OnLoadCarsListener, CarListContract.Model.OnDeleteCarListener {

    private CarListModel model;
    private CarListView view;

    public CarListPresenter(CarListView view) {
        model = new CarListModel();
        model.startDb(view.getApplicationContext());

        this.view = view;
    }

    @Override
    public void loadAllCars() {
        model.loadAllCars(this);
    }

    @Override
    public void loadCarsByBrand(String query) {
        model.loadCarsByBrand(this, query);
    }

    @Override
    public void loadCarsByModel(String query) {
        model.loadCarsByModel(this, query);
    }



    @Override
    public void loadCarsByHorsePower(String query) {
        model.loadCarsByHorsePower(this, query);
    }

    @Override   // OnLoadComputersListener SUCCESS
    public void onLoadCarsSuccess(List<Car> computers) {
        view.listCars(computers);
    }

    @Override   // OnLoadComputersListener ERROR
    public void onLoadCarsError(String message) {
        view.showMessage(message);
    }

    @Override
    public void deleteCar(Car car) {
        model.delete(this, car);
    }

    @Override   // OnDeleteComputersListener SUCCESS
    public void onDeleteCarSuccess(String message) {
        view.showMessage(message);
    }

    @Override   // OnDeleteComputersListener ERROR
    public void onDeleteCarError(String message) {
        view.showMessage(message);
    }
}
