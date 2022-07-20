package com.example.josnreader.ui;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.josnreader.model.Josn;
import com.example.josnreader.pojo.webServices.JosnClient;
import com.example.josnreader.pojo.webServices.JosnInterface;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JosnViewModel extends ViewModel {
    MutableLiveData<List<Josn>> mutableLiveData = new MutableLiveData<>();

    void getData(){
        JosnInterface josnInterface = JosnClient.retrofitInstance().create(JosnInterface.class);
        Call<List<Josn>> call =josnInterface.getJosn();
        call.enqueue(new Callback<List<Josn>>() {
            @Override
            public void onResponse(Call<List<Josn>> call, Response<List<Josn>> response) {
                if (response.isSuccessful()){
                    mutableLiveData.setValue(response.body());
                }
                Log.d("TAG", response.body()+"");
            }
            @Override
            public void onFailure(Call<List<Josn>> call, Throwable t) {
                Log.d("TAG" , t.getMessage());
            }
        });
    }
}
