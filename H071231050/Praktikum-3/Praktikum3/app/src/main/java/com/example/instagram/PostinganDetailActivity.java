package com.example.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostinganDetailActivity extends AppCompatActivity {
    RecyclerView post;
    TextView name;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postingan);

        String Username = getIntent().getStringExtra("nama");

        // Inisialisasi RecyclerView
        post = findViewById(R.id.rv_post);
        btnBack = findViewById(R.id.back);

        name = findViewById(R.id.name);
        name.setText(Username);

//      Ambil data postingan berdasarkan username
        ArrayList<Postingan> userPosts = DataSourcePostingan.getPostinganByUsername(Username);

//         Setup RecyclerView dengan GridLayoutManager (3 kolom)
        DetailPostinganAdapter adapter = new DetailPostinganAdapter(userPosts);
        post.setLayoutManager(new LinearLayoutManager(this));
        post.setAdapter(adapter);

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("nama", Username);
            startActivity(intent);
            finish();
        });


    }
}
