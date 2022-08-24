package com.svalero.aa2pmdmrecu.api;

import com.svalero.aa2pmdmrecu.domain.Car;
import com.svalero.aa2pmdmrecu.domain.Reparation;
import com.svalero.aa2pmdmrecu.domain.User;
import com.svalero.aa2pmdmrecu.domain.dto.CarDTO;
import com.svalero.aa2pmdmrecu.domain.dto.ReparationDTO;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AA2PmdmRecuInterface {

    // Cars
    @GET("cars?all=true")
    Call<List<Car>> getCars();

    @GET("cars")
    Call<List<Car>> getCarsByBrand(@Query("brand") String brand);

    @GET("cars")
    Call<List<Car>> getCarsByModel(@Query("model") String model);

    @GET("cars")
    Call<List<Car>> getCarsByHorsePower(@Query("horsePower") String horsePower);

    @GET("user/{id}/cars")
    Call<List<Car>> getCarsByUserId(@Path("id") long id);

    @DELETE("car/{id}")
    Call<Void> deleteCar(@Path("id") long id);

    @POST("cars")
    Call<Car> addCar(@Body CarDTO carDTO);

    @PUT("car/{id}")
    Call<Car> modifyCar(@Path("id") long id, @Body CarDTO carDTO);

    // Users
    @GET("users?all=true")
    Call<List<User>> getUsers();

    @GET("users")
    Call<List<User>> getUsersByName(@Query("name") String name);

    @GET("users")
    Call<List<User>> getUsersBySurname(@Query("surname") String surname);

    @GET("users")
    Call<List<User>> getUsersByDni(@Query("dni") String dni);

    @DELETE("user/{id}")
    Call<Void> deleteUsers(@Path("id") long id);

    @POST("users")
    Call<User> addUser(@Body User user);

    @PUT("user/{id}")
    Call<User> modifyUser(@Path("id") long id, @Body User user);

    // REPARATIONS
    @POST("reparation")
    Call<Reparation> addReparation(@Body ReparationDTO reparationDTO);

    @PUT("reparation/{id}")
    Call<Reparation> modifyReparation(@Path("id") long id, @Body ReparationDTO reparationDTO);


}
