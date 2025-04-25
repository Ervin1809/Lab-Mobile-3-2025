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
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HighlightAdapter extends RecyclerView.Adapter<HighlightAdapter.ViewHolder> {
    private ArrayList<Highlight> stroy;
    private String username;
    private int profile;


    public HighlightAdapter(ArrayList<Highlight> highlights, String username, int profile){
        this.stroy = highlights;
        this.username = username;
        this.profile = profile;
    }



    @NonNull
    @Override
    public HighlightAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.highlight_profile_layout,parent,false);
        return new HighlightAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HighlightAdapter.ViewHolder holder, int position) {
        Highlight high = stroy.get(position);
        holder.lv_highlight.setImageResource(high.getHighlight());
        int image = high.getHighlight();
        holder.lv_highlight.setOnClickListener(v -> {
            Intent intent = new Intent (holder.itemView.getContext(), StoryActivity.class);
            intent.putExtra("nama", username);
            intent.putExtra("profil", profile);
            intent.putExtra("image", image);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return stroy.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView lv_highlight;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lv_highlight = itemView.findViewById(R.id.highlight);
        }
    }
}
