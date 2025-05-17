package com.example.networking.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.networking.R;
import com.example.networking.data.response.User;

import java.util.List;

public class RickyAdapter extends RecyclerView.Adapter<RickyAdapter.ViewHolder> {

    private final List<User> userList;

    public RickyAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ricky, parent, false);
        return new RickyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.itemName.setText(user.getName());
        holder.Jenis.setText(user.getSpecies());
        Glide.with(holder.itemView.getContext())
                .load(user.getImage()) // Pastikan Book punya method getImageUrl()
                .into(holder.imageView); // Pastikan ini adalah ImageView

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), RickyDetailActivity.class);
            intent.putExtra("id", user.getId());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return userList != null ? userList.size() : 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView itemName, Jenis;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.tv_image);
            itemName = itemView.findViewById(R.id.tv_name);
            Jenis = itemView.findViewById(R.id.tv_jenis);


            // Initialize your views here
        }
    }
}
