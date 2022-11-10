package com.example.basketballabasketballyeahwellyourmotherisabasketball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.basketballabasketballyeahwellyourmotherisabasketball.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int punkty=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                punkty++;
                        binding.punktytextView.setText(String.valueOf(punkty));
            }
        });
    }
}