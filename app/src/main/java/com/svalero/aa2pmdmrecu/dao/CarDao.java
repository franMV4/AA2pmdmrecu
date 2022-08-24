package com.svalero.aa2pmdmrecu.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.svalero.aa2pmdmrecu.domain.Car;

import java.util.List;

@Dao
public interface CarDao {


    @Query("SELECT * FROM car")
    List<Car> getAll();

    @Query("SELECT * FROM car WHERE id = :id")
    Car getCarById(String id);

    @Query("SELECT * FROM car WHERE brand LIKE :query")
    List<Car> getByBrandString(String query);

    @Query("SELECT * FROM car WHERE model LIKE :query")
    List<Car> getByModelString(String query);



    /*
    @Query("SELECT * FROM computer WHERE userId = :userId")
    List<Computer> getComputersByUserId(int userId);
    */

    @Insert
    void insert(Car car);

    @Update
    void update(Car car);

    @Delete
    void delete(Car car);




}
