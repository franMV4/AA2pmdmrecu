package com.svalero.aa2pmdmrecu.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.svalero.aa2pmdmrecu.domain.Garage;

import java.util.List;

@Dao
public interface GarageDao {

    @Query("SELECT * FROM garage")
    List<Garage> getAll();

    @Query("SELECT * FROM garage WHERE id = :id")
    Garage getGarageById(String id);

    @Query("SELECT * FROM garage WHERE city LIKE :query")
    List<Garage> getByCityString(String query);

    @Query("SELECT * FROM garage WHERE street LIKE :query")
    List<Garage> getByStreetString(String query);


    @Insert
    void insert(Garage garage);

    @Update
    void update(Garage garage);

    @Delete
    void delete(Garage garage);



}
