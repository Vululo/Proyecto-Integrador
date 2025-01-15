package com.brunov.proyectointegrador;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.brunov.proyectointegrador.api.ApiClient;
import com.brunov.proyectointegrador.api.ApiService;
import com.brunov.proyectointegrador.Fuentes;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);

        // Llamar al endpoint
        Call<List<Fuentes>> call = apiService.getFuentes();
        call.enqueue(new Callback<List<Fuentes>>() {
            @Override
            public void onResponse(Call<List<Fuentes>> call, Response<List<Fuentes>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Manejar los datos recibidos
                    List<Fuentes> fuentes = response.body();
                    for (Fuentes fuente : fuentes) {
                        Log.d("API Response", "Fuente: " + fuente.getNomVia() + " - " + fuente.getLatitud() + ", " + fuente.getLongitud());
                    }
                } else {
                    Log.e("API Response", "Error en la respuesta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Fuentes>> call, Throwable t) {
                Log.e("API Error", t.getMessage());
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}