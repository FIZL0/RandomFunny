package com.example.randomfunny.networking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {
    String BASE_URL = "https://meme-api.com/";

    @GET("gimme")
    Call<MemeResult> getMemes();
}
