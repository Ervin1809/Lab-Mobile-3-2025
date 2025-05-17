package com.example.networking.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.networking.R;
import com.example.networking.data.network.ApiConfig;
import com.example.networking.data.response.User;
import com.example.networking.data.response.UserResponse;
import com.example.networking.home.MainActivity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RickyDetailActivity extends AppCompatActivity {
    private ImageView characterImage;

    private ProgressBar progressBar;

    private ConstraintLayout content;
    private Button btnBack;
    private int id;
    private TextView characterName, characterStatus, characterSpecies, characterGender;

    private User userSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ricky_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        characterImage = findViewById(R.id.character_image);
        btnBack = findViewById(R.id.back_button);
        characterName = findViewById(R.id.character_name);
        characterStatus = findViewById(R.id.character_status);
        characterSpecies = findViewById(R.id.character_species);
        characterGender = findViewById(R.id.character_gender);

        // Ambil data dari Intent
        id = getIntent().getIntExtra("id", 0);
        progressBar = findViewById(R.id.progressBar);
        content = findViewById(R.id.content);
        content.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        executor.execute(() -> {
            try {
                final String[] name = {""};
//                for (int i = 0; i <= 10; i++) {
//                Thread.sleep(2000);
                Thread.sleep(0);
                ApiConfig.getApiService().getUserById(id).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            userSimpan = response.body();
                            name[0] = userSimpan.getName();
                            Log.d("userSimpan", userSimpan.toString());
//                            characterName.setText(user.getName());
//                            characterStatus.setText(user.getStatus());
//                            characterSpecies.setText(user.getSpecies());
//                            characterGender.setText(user.getGender());
//
//                            String imageUrl = user.getImage();
//                            if (!isFinishing() && !isDestroyed()) {
//                                Glide.with(RickyDetailActivity.this)
//                                        .load(imageUrl)
//                                        .into(characterImage);
//                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        // Tampilkan log atau toast
                    }


                });
                handler.postDelayed(() -> {
                    // Update UI setelah mendapatkan data
                    if (userSimpan != null) {
                        progressBar.setVisibility(View.GONE);
                        content.setVisibility(View.VISIBLE);
                        characterName.setText(userSimpan.getName());
                        characterStatus.setText(userSimpan.getStatus());
                        characterSpecies.setText(userSimpan.getSpecies());
                        characterGender.setText(userSimpan.getGender());

                        String imageUrl = userSimpan.getImage();
                        if (!isFinishing() && !isDestroyed()) {
                            Glide.with(RickyDetailActivity.this)
                                    .load(imageUrl)
                                    .into(characterImage);
                        }
                    }
                }, 4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        btnBack.setOnClickListener(v -> {
            finish();
        });

    }
}