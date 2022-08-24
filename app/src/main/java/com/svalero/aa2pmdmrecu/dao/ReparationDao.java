package com.svalero.aa2pmdmrecu.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.svalero.aa2pmdmrecu.domain.Reparation;

import java.util.List;

@Dao
public interface ReparationDao {




    @Query("SELECT * FROM `Reparation`")
    List<Reparation> getAll();

    @Query("SELECT * FROM `Reparation` WHERE repairedPart LIKE :query")
    List<Reparation> getByRepairedPart(String query);

    @Query("SELECT * FROM `Reparation` WHERE cost LIKE :query")
    List<Reparation> getByCostInt(int query);

    @Insert
    void insert(Reparation reparation);

    @Update
    void update(Reparation reparation);

    @Delete
    void delete(Reparation reparation);



}
