package com.svalero.aa2pmdmrecu.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.svalero.aa2pmdmrecu.R;
import com.svalero.aa2pmdmrecu.contract.AddCarContract;
import com.svalero.aa2pmdmrecu.domain.Car;
import com.svalero.aa2pmdmrecu.domain.User;
import com.svalero.aa2pmdmrecu.presenter.AddCarPresenter;
import com.svalero.aa2pmdmrecu.util.ImageUtils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class AddCarView extends AppCompatActivity implements AddCarContract.View {

    private Car car;
    private User user;

    private Button addButton;
    private ImageView carImage;
    private Spinner userSpinner;
    private EditText etBrand;
    private EditText etModel;
    private EditText etHorsePower;
    private CheckBox cbFavourite;
    private Intent intent;
    private AddCarPresenter presenter;

    private boolean modifyCar;
    public List<User> users;

    public Button getAddButton() {
        return addButton;
    }

    public void setModifyCar(boolean modifyCar) {
        this.modifyCar = modifyCar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_view);

        carImage = findViewById(R.id.car_imageView);
        etBrand = findViewById(R.id.brand_edittext_add_car);
        etModel = findViewById(R.id.model_edittext_add_car);
        etHorsePower = findViewById(R.id.horsePower_edittext_add_car);
        cbFavourite = findViewById(R.id.favourite_checkbox_add_car);
        userSpinner = findViewById(R.id.user_spinner_add_car);
        addButton = findViewById(R.id.add_car_button);

        presenter = new AddCarPresenter(this);
        car = new Car();
        user = new User();
        users = new ArrayList<>();

        presenter.loadUsersSpinner(); //MVP
        intent();
    }


    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadUsersSpinner(); //MVP
    }

    @Override
    public void loadUserSpinner(List<User> users) {

        this.users.clear();
        this.users.addAll(users);

        String[] arraySpinner = new String[users.size()];

        for (int i = 0; i < users.size(); i++) {
            arraySpinner[i] = users.get(i).getName() + " " + users.get(i).getSurname();
        }

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arraySpinner);
        userSpinner.setAdapter(adapterSpinner);

    }

    private void intent() {

        intent = getIntent();
        modifyCar = intent.getBooleanExtra("modify_car", false);
        // Si se está editando la moto, obtiene los datos de la moto y los pinta en el formulario
        if (modifyCar) {
            car.setId(intent.getLongExtra("id", 0));
            user.setId(intent.getLongExtra("userId", 0));
            Log.i("userId", "id" + user.getId());
            car.setUser(user);

            etBrand.setText(intent.getStringExtra("brand"));
            etModel.setText(intent.getStringExtra("model"));
            etHorsePower.setText(intent.getStringExtra("horsePower"));
            cbFavourite.setChecked(intent.getBooleanExtra("favourite", false));


            addButton.setText(R.string.modify_capital);
        }
    }

    @Override
    public void addCar(View view) {

        car.setBrand(etBrand.getText().toString().trim());
        car.setModel(etModel.getText().toString().trim());
        car.setFavourite(cbFavourite.isChecked());
        //TODO Arreglar mirar en los otros int y copiar codigo
        car.setHorsePower(etHorsePower.getText().toString().trim());
        user.setId(users.get(userSpinner.getSelectedItemPosition()).getId());
        Log.i("userId", "id" + user.getId());
        car.setUser(user);
        presenter.addOrModifyCar(car, modifyCar);

    }

    @Override
    public void cleanForm() {

        carImage.setImageResource(R.drawable.computer_default);
        etBrand.setText("");
        etModel.setText("");
        etHorsePower.setText("");
        cbFavourite.setChecked(false);

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }





}