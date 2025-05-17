package com.example.praktikum4.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.praktikum4.Model.DetailBook;
import com.example.praktikum4.Model.Book;
import com.example.praktikum4.R;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private ArrayList<Book> books;

    //    private Context context;
//
//    public BookAdapter(Context context, ArrayList<Book> books) {
//        this.context = context;
//        this.books = books;
//    }
    public BookAdapter(ArrayList<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        Book book = books.get(position);
        holder.txtTitle.setText(book.getTitle());
        holder.txtAuthor.setText(book.getAuthor());
        if (book.getImage() == null) {
            holder.imgBook.setImageURI(book.getImageUri());
        } else {
            Glide.with(holder.itemView.getContext())
                    .load(book.getImage()) // Pastikan Book punya method getImageUrl()
                    .into(holder.imgBook); // Pastikan ini adalah ImageView
        }


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailBook.class);
            intent.putExtra("title", book.getTitle());
            intent.putExtra("author", book.getAuthor());
            if (book.getImage() == null) {
                intent.putExtra("image", book.getImageUri());
            } else {
                intent.putExtra("image", book.getImage());
            }
            intent.putExtra("description", book.getBlurb());
            intent.putExtra("tahunTerbit", book.getTahunTerbit());
            intent.putStringArrayListExtra("genres", new ArrayList<>(book.getGenres()));
            intent.putExtra("statusLike", book.isStatusLike());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    public void setData(ArrayList<Book> newBookList) {
        this.books = new ArrayList<>(newBookList);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgBook;
        private TextView txtTitle, txtAuthor;
        private RelativeLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBook = itemView.findViewById(R.id.imgBook);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            container = itemView.findViewById(R.id.layoutBook);
        }
    }
}
