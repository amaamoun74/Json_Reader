package com.example.josnreader.pojo.webServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JosnClient {
    public static Retrofit retrofit;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static Retrofit retrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
