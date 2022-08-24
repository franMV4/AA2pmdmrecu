package com.svalero.aa2pmdmrecu.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.svalero.aa2pmdmrecu.dao.CarDao;
import com.svalero.aa2pmdmrecu.dao.GarageDao;
import com.svalero.aa2pmdmrecu.dao.ReparationDao;
import com.svalero.aa2pmdmrecu.dao.UserDao;
import com.svalero.aa2pmdmrecu.domain.Car;
import com.svalero.aa2pmdmrecu.domain.Garage;
import com.svalero.aa2pmdmrecu.domain.Reparation;
import com.svalero.aa2pmdmrecu.domain.User;


@Database(entities = {Car.class, Garage.class, Reparation.class, User.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CarDao carDao();

    public abstract GarageDao garageDao();

    public abstract ReparationDao reparationDao();

    public abstract UserDao userDao();

}
