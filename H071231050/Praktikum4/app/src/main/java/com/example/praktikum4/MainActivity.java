package com.example.praktikum4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.praktikum4.Fragment.AddBookFragment;
import com.example.praktikum4.Fragment.FavoriteFragment;
import com.example.praktikum4.Fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    Button btnHome, btnAdd, btnFavorite;
    public ProgressBar progressBar;

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
        replaceFragment(new HomeFragment());

        btnHome = findViewById(R.id.btnHome);
        btnAdd = findViewById(R.id.btnAdd);
        btnFavorite = findViewById(R.id.btnFavorite);
        progressBar = findViewById(R.id.progressBarUpload);

        btnHome.setOnClickListener(v -> replaceFragment(new HomeFragment()));
        btnAdd.setOnClickListener(v -> replaceFragment(new AddBookFragment()));
        btnFavorite.setOnClickListener(v -> replaceFragment(new FavoriteFragment()));





    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null); // Menambahkan transaksi ke back stack
        transaction.commit();
    }
}