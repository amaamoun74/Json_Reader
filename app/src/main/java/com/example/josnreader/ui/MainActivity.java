package com.example.josnreader.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.josnreader.R;
import com.example.josnreader.model.Josn;
import com.example.josnreader.pojo.adapter.JosnAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    JosnViewModel viewModel;
    RecyclerView recyclerView;
    JosnAdapter josnAdapter;
    //List<Josn> josnList =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(JosnViewModel.class);

      //  josnAdapter = new JosnAdapter(josnList,this);
        josnAdapter = new JosnAdapter();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(josnAdapter);
        getObservedData();
    }

    void getObservedData() {
        viewModel.mutableLiveData.observe(this, josns ->
        {
          //  josnList.addAll(josns);
            josnAdapter.setList(josns);
        });
        viewModel.getData();
    }
}