package com.example.basketballabasketballyeahwellyourmotherisabasketball;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.basketballabasketballyeahwellyourmotherisabasketball.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    //private int punkty=0;
    PunktyViewModel punktyViewModel;
    private SharedPreferences punktySharePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        punktySharePreferences = getPreferences(MODE_PRIVATE);
        punktyViewModel = new ViewModelProvider(this).get(PunktyViewModel.class);
        odczytajSharedPreferences();
        punktyViewModel.getPunkty().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.punktytextView.setText(String.valueOf(integer));
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //punkty++;
                punktyViewModel.dodajPunkty(1);
            }
        });

        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //punkty++;
                punktyViewModel.dodajPunkty(2);
            }
        });

        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //punkty++;
                punktyViewModel.dodajPunkty(3);
            }
        });


    }

    @Override
    protected void onPause(){
        super.onPause();
        zapiszSharePreferences();
    }

    private void zapiszSharePreferences(){
        SharedPreferences.Editor edytor = punktySharePreferences.edit();
        edytor.putInt("PUNKTY", punktyViewModel.getPunkty().getValue());
        edytor.apply();
    }

    private void odczytajSharedPreferences(){
        int p = punktySharePreferences.getInt("PUNKTY", 0);
        punktyViewModel.setPunkty(p);
    }
}