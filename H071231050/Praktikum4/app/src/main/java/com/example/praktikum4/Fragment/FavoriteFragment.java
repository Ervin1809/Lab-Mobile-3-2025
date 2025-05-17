package com.example.praktikum4.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.praktikum4.Adapter.BookAdapter;
import com.example.praktikum4.Adapter.GenreAdapter;
import com.example.praktikum4.DataSource.BookDataSource;
import com.example.praktikum4.Model.Book;
import com.example.praktikum4.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FavoriteFragment extends Fragment {
    private RecyclerView catalogBooks, genre;
    private ArrayList<Book> BookList;

    BookAdapter adapter;

    ProgressBar progressBar;

    String genreSelected = "All";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        //      ProgressBar
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

//      AdapterBook
        catalogBooks = view.findViewById(R.id.catalogBookFavorite);
        BookList = BookDataSource.getBookFavorite();
        adapter = new BookAdapter(BookList);
        catalogBooks.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        catalogBooks.setAdapter(adapter);

//      AdapterGenre
        genre = view.findViewById(R.id.genreFavorite);
        ArrayList<String> genreList = BookDataSource.getGenre();
        GenreAdapter genreAdapter = new GenreAdapter(genreList, new GenreAdapter.OnGenreClickListener() {
            @Override
            public void onGenreClick(String selectedGenre) {
                progressBar = view.findViewById(R.id.progressBarCatalog);
                progressBar.setVisibility(View.VISIBLE);
                catalogBooks.setVisibility(View.GONE);
                executor.execute(() -> {
                    try {
                        for (int i = 0; i <= 10; i++) {
                            Thread.sleep(2000);
                            handler.post(() -> {
                                progressBar.setVisibility(View.GONE);
                                catalogBooks.setVisibility(View.VISIBLE);
                            });
                        }
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                filterBooksByGenreFavorite(selectedGenre);
                genreSelected = selectedGenre;
            }
        });
        genre.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        genre.setAdapter(genreAdapter);



//      EditText Search
        EditText etSearch = view.findViewById(R.id.editTextSearch);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                progressBar = view.findViewById(R.id.progressBarCatalog);
                progressBar.setVisibility(View.VISIBLE);
                catalogBooks.setVisibility(View.GONE);
                executor.execute(() -> {
                    try {
                        for (int i = 0; i <= 10; i++) {
                            Thread.sleep(2000);
                            handler.post(() -> {
                                progressBar.setVisibility(View.GONE);
                                catalogBooks.setVisibility(View.VISIBLE);
                            });
                        }
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                ArrayList<Book> filteredBooks = BookDataSource.filterByTitle(s.toString(), "favorite",genreSelected);
                adapter.setData(filteredBooks);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        progressBar = view.findViewById(R.id.progressBarCatalog);
        progressBar.setVisibility(View.VISIBLE);
        catalogBooks.setVisibility(View.GONE);
        executor.execute(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(2000);
                    handler.post(() -> {
                        progressBar.setVisibility(View.GONE);
                        catalogBooks.setVisibility(View.VISIBLE);
                    });
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return view;
    }

    // Filter books by genre
    private void filterBooksByGenreFavorite(String genre) {
        ArrayList<Book> allBooks = BookDataSource.getBookFavorite();
        ArrayList<Book> filteredBooks = new ArrayList<>();

        if(genre.equals("All")){
            adapter.setData(allBooks);
            return;
        }else{
            for (Book book : allBooks) {
                if (book.getGenres().contains(genre)) {
                    filteredBooks.add(book);
                }
            }
        }

        adapter.setData(filteredBooks); // Update adapter-nya
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onResume() {
        super.onResume();
        // Panggil metode untuk refresh data setiap kali fragment dibuka
        refreshFragmentData();
    }

    private void refreshFragmentData() {
        // Misalnya, memanggil data terbaru dari sumber data (seperti dari database atau API)
        // Contoh:
        ArrayList<Book> updatedBooks = BookDataSource.getBookFavorite();
        adapter.setData(updatedBooks);  // Mengupdate adapter dengan data terbaru
    }
}