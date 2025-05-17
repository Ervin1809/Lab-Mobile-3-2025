package com.example.networking.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networking.R;
import com.example.networking.data.network.ApiConfig;
import com.example.networking.data.response.User;
import com.example.networking.data.response.UserResponse;
import com.example.networking.ui.RickyAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RickyAdapter adapter;
    private RecyclerView container;
    private int currentPage = 1;
    private boolean isLoading = false;
    private List<User> userList = new ArrayList<>();

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        progressBar = findViewById(R.id.progressBar);
        container = findViewById(R.id.container);
        container.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RickyAdapter(userList);
        container.setAdapter(adapter);

        container.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        loadData(currentPage, executor, handler); // load page 1

        Button btnLoadMore = findViewById(R.id.button_load_more);
        btnLoadMore.setOnClickListener(v -> {
            currentPage++;
            progressBar.setVisibility(View.VISIBLE);
            loadData(currentPage, executor, handler);
        });
    }

    private void loadData(int page, ExecutorService executor, Handler handler) {
        if (isLoading) return;
        isLoading = true;

        executor.execute(() -> {
            try {
//                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(4000);
                    handler.post(() -> {
                        progressBar.setVisibility(View.GONE);
                        container.setVisibility(View.VISIBLE);
                        ApiConfig.getApiService().getListUsers(page).enqueue(new Callback<UserResponse>() {
                            @Override
                            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                                isLoading = false;
                                if (response.isSuccessful() && response.body() != null) {
                                    List<User> newUsers = response.body().getResults(); // pastikan method ini sesuai UserResponse kamu
                                    if (newUsers != null) {
                                        userList.addAll(newUsers);
                                        adapter.notifyDataSetChanged();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<UserResponse> call, Throwable t) {
                                isLoading = false;
                                // bisa tambahkan log atau Toast di sini
                            }
                        });
                    });
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
