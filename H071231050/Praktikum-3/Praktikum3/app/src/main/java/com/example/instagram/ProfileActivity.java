package com.example.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    RecyclerView rvGrid, rvStory;
    CircleImageView profile, btnKeProfile;
    TextView username, nama, followers, following, postingan;
    MaterialButton btnEdit, btnShare;
    ImageView  btnHome,btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        username = findViewById(R.id.username);
        profile = findViewById(R.id.iv_profile);
        nama = findViewById(R.id.name);
        followers = findViewById(R.id.followers);
        following = findViewById(R.id.following);
        postingan = findViewById(R.id.jumlahPostingan);
        btnEdit = findViewById(R.id.editPorfil);
        btnShare = findViewById(R.id.share);
        btnHome = findViewById(R.id.home);
        btnUpload = findViewById(R.id.upload);
        rvStory = findViewById(R.id.pageKeempat);
        btnKeProfile = findViewById(R.id.btnKeProfile);

        String Username = getIntent().getStringExtra("nama");

        if (Username.equals("ervinhsn")) {
            btnEdit.setText("Edit profil");
            btnShare.setText("Bagikan profil");
        } else {
            btnEdit.setText("Mengikuti");
            btnShare.setText("Pesan");
        }

        UserStats userStats = DataSourcePostingan.getStatsByUsername(Username);


        username.setText(Username);
        nama.setText(userStats.name);
        followers.setText(userStats.getFormattedFollowers());
        following.setText(userStats.getFormattedFollowing());
        postingan.setText(String.valueOf(userStats.posts));
        profile.setImageResource(userStats.profile);

        ArrayList<Highlight> userStory = DataSourcePostingan.getHighlightByUsername(Username);

        HighlightAdapter adapter1 = new HighlightAdapter(userStory, Username, userStats.profile);
        rvStory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
        rvStory.setAdapter(adapter1);

        // Inisialisasi RecyclerView
        rvGrid = findViewById(R.id.rv_grid);

        // Ambil data postingan berdasarkan username
        ArrayList<Postingan> userPosts = DataSourcePostingan.getPostinganByUsername(Username);

        // Setup RecyclerView dengan GridLayoutManager (3 kolom)
        PostinganProfileAdapter adapter = new PostinganProfileAdapter(userPosts);
        rvGrid.setLayoutManager(new GridLayoutManager(this, 3));
        rvGrid.setAdapter(adapter);

        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        btnKeProfile.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
            intent.putExtra("nama", "ervinhsn");
            startActivity(intent);
            finish();
        });

        btnUpload.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, UploadActivity.class);
            intent.putExtra("nama", "ervinhsn");
            startActivity(intent);
            finish();
        });



    }

}
