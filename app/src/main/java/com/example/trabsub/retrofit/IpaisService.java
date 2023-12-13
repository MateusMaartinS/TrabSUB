package com.example.trabsub.retrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IpaisService {

    @GET("api/paises")
    Call<ArrayList<PaisDTO>> getPaises();
}
