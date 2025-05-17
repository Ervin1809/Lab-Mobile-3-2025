package com.example.praktikum4.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktikum4.R;

import java.util.ArrayList;
import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {
    ArrayList<String> genreList;
    private OnGenreClickListener listener;

    public GenreAdapter(ArrayList<String> genreList, OnGenreClickListener listener) {
        this.genreList = genreList;
        this.listener = listener;
    }


    public interface OnGenreClickListener {
        void onGenreClick(String genre);
    }


    @NonNull
    @Override
    public GenreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreAdapter.ViewHolder holder, int position) {
        String genre = genreList.get(position);
        holder.btnGenre.setText(genre);
        holder.btnGenre.setOnClickListener(v -> {
            if (listener != null) {
                listener.onGenreClick(genre);
            }
        });
    }

    @Override
    public int getItemCount() {
        return genreList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnGenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnGenre = itemView.findViewById(R.id.btnGenre);
        }
    }
    //    private Context context;
}
