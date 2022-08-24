package com.svalero.aa2pmdmrecu.presenter;

import android.content.Context;

import com.svalero.aa2pmdmrecu.R;
import com.svalero.aa2pmdmrecu.contract.AddCarContract;
import com.svalero.aa2pmdmrecu.domain.Car;
import com.svalero.aa2pmdmrecu.domain.User;
import com.svalero.aa2pmdmrecu.model.AddCarModel;
import com.svalero.aa2pmdmrecu.view.AddCarView;

import java.util.List;

public class AddCarPresenter implements AddCarContract.Presenter, AddCarContract.Model.OnLoadUsersListener, AddCarContract.Model.OnAddCarListener, AddCarContract.Model.OnModifyCarListener{





    private AddCarModel model;
    private AddCarView view;
    private Context context;

    public AddCarPresenter(AddCarView view) {
        this.context = view.getApplicationContext();
        this.view = view;

        model = new AddCarModel();
        model.startDb(context);
    }

    @Override
    public void loadUsersSpinner() {
        model.loadAllUser(this);
    }

    @Override
    public void addOrModifyCar(Car car, Boolean modifyCar) {
        if ((car.getBrand().equals("")) || (car.getModel().equals("")) || (car.getHorsePower().equals("") )) {
            view.showMessage("Completa todos los campos");
        } else {
            if (modifyCar) {
                view.setModifyCar(false);
                view.getAddButton().setText(R.string.add_button);
                model.modifyCar(this, car);
            } else {
                car.setId(0);
                model.addCar(this, car);
            }
        }
    }

    @Override
    public void onLoadUsersSuccess(List<User> users) {
        view.loadUserSpinner(users);
    }

    @Override
    public void onLoadUsersError(String message) {
        view.showMessage(message);
    }

    @Override
    public void onAddCarSuccess(String message) {
        view.showMessage(message);
        view.cleanForm();
    }

    @Override
    public void onAddCarError(String message) {
        view.showMessage(message);
    }

    @Override
    public void onModifyCarSuccess(String message) {
        view.showMessage(message);
        view.cleanForm();
    }

    @Override
    public void onModifyCarError(String message) {
        view.showMessage(message);
    }
}




