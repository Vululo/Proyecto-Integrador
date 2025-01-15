package com.brunov.proyectointegrador.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://datos.madrid.es/datosabiertos/CIUAB/MINT/FUENTES_BEBER/2025/01/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL) // Define la URL base
                    .addConverterFactory(GsonConverterFactory.create()) // Convierte JSON a objetos
                    .build();
        }
        return retrofit;
    }
}

