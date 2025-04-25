package com.example.instagram;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.Postingan;
import com.example.instagram.R;

import java.util.ArrayList;

public class PostinganProfileAdapter extends RecyclerView.Adapter<PostinganProfileAdapter.ViewHolder> {

    private ArrayList<Postingan> postList;

    public PostinganProfileAdapter(ArrayList<Postingan> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostinganProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postingan_profile_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostinganProfileAdapter.ViewHolder holder, int position) {
        Postingan post = postList.get(position);
//        holder.nama.setText(post.getName());
        if (post.getImagePostingan() == 0){
            holder.imagePost.setImageURI(post.getUri());
        }else{
            holder.imagePost.setImageResource(post.getImagePostingan());
        }
//        holder.imagePost.setImageResource(post.getImagePostingan());

        holder.imagePost.setOnClickListener(v -> {
            Intent intent = new Intent (holder.itemView.getContext(), PostinganDetailActivity.class);
            intent.putExtra("nama", post.getName().toString());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePost = itemView.findViewById(R.id.image_post);
        }
    }
}
