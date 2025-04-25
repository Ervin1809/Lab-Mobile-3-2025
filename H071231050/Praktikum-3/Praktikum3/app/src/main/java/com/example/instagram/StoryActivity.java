package com.example.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryActivity extends AppCompatActivity {
    CircleImageView foto_profil;
    TextView username;
    ImageView story, close;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        foto_profil = findViewById(R.id.profile);
        username = findViewById(R.id.username);
        story = findViewById(R.id.storyImage);
        close = findViewById(R.id.close);

        String usernameIg = getIntent().getStringExtra("nama");
        int fotoStory = getIntent().getIntExtra("image", R.drawable.aipun);
        int fotoProfil = getIntent().getIntExtra("profil", R.drawable.aipun);

        username.setText(usernameIg);
        foto_profil.setImageResource(fotoProfil);
        story.setImageResource(fotoStory);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoryActivity.this, ProfileActivity.class);
                intent.putExtra("nama", usernameIg);
                startActivity(intent);
                finish();
            }
        });
    }
}
