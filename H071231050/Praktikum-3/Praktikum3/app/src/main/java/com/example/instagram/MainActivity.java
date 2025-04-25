package com.example.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_postingan;
    CircleImageView btnToProfile;
    ImageView btnUpload;

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

        rv_postingan = findViewById(R.id.rv_postingan);
        rv_postingan.setLayoutManager(new LinearLayoutManager(this));
        PostinganAdapter postAdapter = new PostinganAdapter(DataSourcePostingan.getSatuPostinganPerUser());

        rv_postingan.setAdapter(postAdapter);

        btnToProfile = findViewById(R.id.btnKeProfile);
        btnToProfile.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("nama","ervinhsn");
            startActivity(intent);
            finish();
        });

        btnUpload = findViewById(R.id.btnUpload);
        btnUpload.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UploadActivity.class);
            intent.putExtra("nama", "ervinhsn");
            startActivity(intent);
            finish();
        });

    }
}