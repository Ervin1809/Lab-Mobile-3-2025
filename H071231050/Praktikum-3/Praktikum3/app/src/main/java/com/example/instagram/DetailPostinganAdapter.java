package com.example.instagram;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailPostinganAdapter extends RecyclerView.Adapter<DetailPostinganAdapter.ViewHolder>{
    private ArrayList<Postingan> posts;

    public DetailPostinganAdapter(ArrayList<Postingan> post) {
        this.posts = post;
    }

    @NonNull
    @Override
    public DetailPostinganAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postingan_layout, parent,false);
        return new DetailPostinganAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailPostinganAdapter.ViewHolder holder, int position) {
        Postingan post = posts.get(position);
        holder.iv_profil.setImageResource(post.getImagePorfil());
        if (post.getImagePostingan() == 0){
            holder.iv_postingan.setImageURI(post.getUri());
        }else{
            holder.iv_postingan.setImageResource(post.getImagePostingan());
        }
        holder.nama.setText(post.getName());
        holder.namaBawah.setText(post.getName());
        holder.iv_like.setText(String.valueOf(post.getLike()));
        holder.iv_comment.setText(String.valueOf(post.getComments()));
        holder.iv_share.setText(String.valueOf(post.getShare()));
        holder.iv_caption.setText(String.valueOf(post.getCaption()));

        holder.nama.setOnClickListener(v -> {
            Intent intent = new Intent (holder.itemView.getContext(), ProfileActivity.class);
            intent.putExtra("nama", holder.nama.getText().toString());
            holder.itemView.getContext().startActivity(intent);
        });
        holder.namaBawah.setOnClickListener(v -> {
            Intent intent = new Intent (holder.itemView.getContext(), ProfileActivity.class);
            intent.putExtra("nama", holder.nama.getText().toString());
            holder.itemView.getContext().startActivity(intent);
        });
        holder.iv_profil.setOnClickListener(v -> {
            Intent intent = new Intent (holder.itemView.getContext(), ProfileActivity.class);
            intent.putExtra("nama", holder.nama.getText().toString());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView iv_profil;
        private ImageView iv_postingan;
        private TextView nama,namaBawah,iv_like,iv_comment,iv_share,iv_caption;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_profil = itemView.findViewById(R.id.iv_profile);
            iv_postingan = itemView.findViewById(R.id.postingan);
            nama = itemView.findViewById(R.id.iv_nameAtas);
            namaBawah = itemView.findViewById(R.id.iv_nameBawah);
            iv_like = itemView.findViewById(R.id.iv_like);
            iv_comment = itemView.findViewById(R.id.iv_comment);
            iv_share = itemView.findViewById(R.id.iv_share);
            iv_caption = itemView.findViewById(R.id.iv_caption);
        }
    }
}
