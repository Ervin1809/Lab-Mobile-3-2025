package com.example.praktikum4.Model;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.praktikum4.DataSource.BookDataSource;
import com.example.praktikum4.Fragment.FavoriteFragment;
import com.example.praktikum4.Fragment.HomeFragment;
import com.example.praktikum4.R;

import java.util.ArrayList;

public class DetailBook extends AppCompatActivity {
    private boolean statusLike;
    ImageView btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_book_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Ambil data dari Intent
        String bookTitle = getIntent().getStringExtra("title");
        String bookAuthor = getIntent().getStringExtra("author");
        String bookDescription = getIntent().getStringExtra("description");
        String bookCover = getIntent().getStringExtra("image");
        String bookPublisher = getIntent().getStringExtra("tahunTerbit");
        statusLike = getIntent().getBooleanExtra("statusLike", false);
        ArrayList<String> bookGenres = getIntent().getStringArrayListExtra("genres");
        // Set data ke TextView dan ImageView di layout activity_detail_book_layout.xml

        TextView titleTextView = findViewById(R.id.txtBookTitle);
        TextView authorTextView = findViewById(R.id.txtBookAuthor);
        TextView descriptionTextView = findViewById(R.id.txtBookBlurb);
        TextView publisherTextView = findViewById(R.id.txtBookYear);
        TextView genres = findViewById(R.id.genres);
        ImageView statusLikeTextView = findViewById(R.id.btnLike);
        ImageView coverImageView = findViewById(R.id.imgBookCover);
        ImageView image = findViewById(R.id.imgBookDetail);

        titleTextView.setText(bookTitle);
        authorTextView.setText(bookAuthor);
        descriptionTextView.setText(bookDescription);
        publisherTextView.setText(bookPublisher);
//        genres.setText(bookGenres.toString());
        if (statusLike) {
            statusLikeTextView.setImageResource(R.drawable.heartred);
        }

        Book book = BookDataSource.getBookByTitle(bookTitle);
        if (book.getImage() == null){
            image.setImageURI(book.getImageUri());
            coverImageView.setImageURI(book.getImageUri());
        }else{
            Glide.with(this)
                    .load(bookCover)
                    .into(coverImageView);

            Glide.with(this)
                    .load(bookCover)
                    .into(image);
        }

        // Set cover image using Glide or any other image loading library

        // Set genres to TextView
        StringBuilder genresString = new StringBuilder();
        for (String genre : bookGenres) {
            genresString.append(genre).append(", ");
        }
        if (genresString.length() > 0) {
            genresString.setLength(genresString.length() - 2); // Remove last comma and space
        }
        genres.setText(genresString.toString());

        // Set onClickListener for the back button
        statusLikeTextView.setOnClickListener(v -> {
            statusLike = !statusLike;
            if (statusLike) {
                statusLikeTextView.setImageResource(R.drawable.heartred);
            } else {
                statusLikeTextView.setImageResource(R.drawable.heart);
            }

            Book bookFromSource = BookDataSource.getBookByTitle(bookTitle);
            if (bookFromSource != null) {
                bookFromSource.setStatusLike(statusLike);
            }
        });

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("statusLike", statusLike);
            setResult(RESULT_OK, resultIntent);
            finish();
        });


    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}