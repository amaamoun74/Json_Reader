package com.example.josnreader.pojo.webServices;

import com.example.josnreader.model.Josn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JosnInterface {
    @GET("/posts")
    Call<List<Josn>> getJosn();
}
