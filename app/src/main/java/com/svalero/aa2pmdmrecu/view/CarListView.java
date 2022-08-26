package com.svalero.aa2pmdmrecu.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.svalero.aa2pmdmrecu.R;
import com.svalero.aa2pmdmrecu.adapters.CarAdapter;
import com.svalero.aa2pmdmrecu.contract.CarListContract;
import com.svalero.aa2pmdmrecu.domain.Car;
import com.svalero.aa2pmdmrecu.presenter.CarListPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarListView extends AppCompatActivity implements CarListContract.View, AdapterView.OnItemClickListener {




    public List<Car> cars;
    public CarAdapter carArrayAdapter;
    public Spinner findSpinner;
    private String orderBy;
    private final String[] FIND_SPINNER_OPTIONS = new String[]{"Marca", "Modelo", "Caballos"};
    private final String DEFAULT_STRING = "";
    private CarListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list_view);
        findSpinner = findViewById(R.id.find_spinner_view_car);
        cars = new ArrayList<>();
        presenter = new CarListPresenter(this);
        carArrayAdapter = new CarAdapter(this, cars);

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, FIND_SPINNER_OPTIONS);
        findSpinner.setAdapter(adapterSpinner);

        orderBy = DEFAULT_STRING;

        findCarsBy(DEFAULT_STRING);
    }

    @Override
    protected void onResume() {
        super.onResume();

        findCarsBy(DEFAULT_STRING);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.car_actionbar, menu);
        final MenuItem searchItem = menu.findItem(R.id.app_bar_car_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                findCarsBy(query.trim());
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                findCarsBy(newText.trim());
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void listCars(List<Car> cars) {

        ListView carsListView = findViewById(R.id.car_lisview);
        registerForContextMenu(carsListView);
        this.cars = cars;

        carArrayAdapter = new CarAdapter(this, this.cars);

        carsListView.setAdapter(carArrayAdapter);
        carsListView.setOnItemClickListener(this);

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Busca las motos según la consulta en la barra de búsqueda del ActionBar y el parámetro de
     * búsqueda seleccionado en el Spinner.
     * Si no hay nada escrito en la barra de búsqueda carga todas las motos.
     * Finalmente llama a OrderBy para ordenarlas según lo indicado en las opciones del ActionBar
     *
     * @param query
     */
    private void findCarsBy(String query) {
        cars.clear();

        if (query.equalsIgnoreCase(DEFAULT_STRING)) {
            presenter.loadAllCars();
        } else {
            switch (findSpinner.getSelectedItemPosition()) {
                case 0:
                    presenter.loadCarsByBrand(query);
                    break;
                case 1:
                    presenter.loadCarsByModel(query);
                    break;
                case 2:
                    Log.i("HorsePower", " presenter.loadCarsByHorsePower(query)");
                    presenter.loadCarsByHorsePower(query);
                    break;
            }
        }
        orderBy(orderBy);
    }

    /**
     * Ordena el ArrayList de motos según la opción seleccionada en el ActionBar
     *
     * @param orderBy String por el cuál ordenar las motos
     */
    private void orderBy(String orderBy) {
        this.orderBy = orderBy;

        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                switch (orderBy) {
                    case "brand":
                        return o1.getBrand().compareToIgnoreCase(o2.getBrand());
                    case "model":
                        return o1.getModel().compareToIgnoreCase(o2.getModel());
                    case "horsePower":
                        return o1.getHorsePower().compareToIgnoreCase(o2.getHorsePower());
                    default:
                        return String.valueOf(o1.getId()).compareTo(String.valueOf(o2.getId()));
                }
            }
        });
        carArrayAdapter.notifyDataSetChanged();
    }

    /**
     * Método para cuando se crea el menu contextual, infle el menu con las opciones
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.listview_menu, menu);

    }

    /**
     * Opciones del menú ActionBar
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.reparation_by_default_item:
                orderBy("");
                return true;
            case R.id.reparation_by_brand_item:
                orderBy("brand");
                return true;
            case R.id.reparation_by_model_item:
                orderBy("model");
                return true;
            case R.id.reparation_by_horsePower_item:
                orderBy("horsePower");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Opciones del menu contextual
     *
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        Intent intent = new Intent(this, AddCarView.class);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        final int itemSelected = info.position;

        switch (item.getItemId()) {
            case R.id.modify_menu:                      // Modificar moto
                Car car = cars.get(itemSelected);
                intent.putExtra("modify_car", true);

                intent.putExtra("id", car.getId());
                intent.putExtra("brand", car.getBrand());
                intent.putExtra("model", car.getModel());
                intent.putExtra("horsePower", car.getHorsePower());
                intent.putExtra("favourite", car.getFavourite());
                intent.putExtra("userId", car.getUser().getId());

                startActivity(intent);
                return true;

            case R.id.detail_menu:                      // Detalles de la moto

                // Todo FALTA usar un fragment para mostrar una ficha con los detalles de la moto

                return true;

            case R.id.add_menu:                         // Añadir moto
                startActivity(intent);
                return true;

            case R.id.delete_menu:                      // Eliminar moto
                deleteCar(info);
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    private void deleteCar(AdapterView.AdapterContextMenuInfo info) {
        Car car = cars.get(info.position);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.are_you_sure_delete_car)
                .setPositiveButton(R.string.yes_capital, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.deleteCar(car);
                        findCarsBy(DEFAULT_STRING);
                    }
                })
                .setNegativeButton(R.string.no_capital, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

    public void addCar(View view) {
        Intent intent = new Intent(this, AddCarView.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}