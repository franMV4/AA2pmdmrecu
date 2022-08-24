package com.svalero.aa2pmdmrecu.contract;

import android.content.Context;

import com.svalero.aa2pmdmrecu.domain.Car;
import com.svalero.aa2pmdmrecu.domain.Reparation;
import com.svalero.aa2pmdmrecu.domain.User;
import com.svalero.aa2pmdmrecu.domain.dto.ReparationDTOAdapter;

import java.util.ArrayList;

public interface ReparationListContract {




    interface Model {
        void startDb(Context context);

        ArrayList<Reparation> loadAllReparations();

        void deleteReparation(Reparation reparation);

        User loadUserById(String id);

        Car loadCarById(String id);
    }

    interface View {
        void listUsers(ArrayList<ReparationDTOAdapter> reparationsDTOArrayList);
    }

    interface Presenter {
        void loadAllReparations();

        void deleteReparation(Reparation reparation);
    }






}
