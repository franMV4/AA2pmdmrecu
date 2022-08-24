package com.svalero.aa2pmdmrecu.api;

import  static com.svalero.aa2pmdmrecu.api.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Aa2PmdmRecuApi {

    public static AA2PmdmRecuInterface buildInstance() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(AA2PmdmRecuInterface.class);
    }
}