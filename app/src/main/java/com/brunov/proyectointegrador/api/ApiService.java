package com.brunov.proyectointegrador.api;

import retrofit2.http.GET;

import com.brunov.proyectointegrador.Fuentes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("fuentes202501")
    Call<List<Fuentes>> getFuentes();
}
