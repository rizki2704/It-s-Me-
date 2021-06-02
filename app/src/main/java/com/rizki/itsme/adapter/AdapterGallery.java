package com.rizki.itsme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rizki.itsme.R;

import org.jetbrains.annotations.NotNull;

public class AdapterGallery extends RecyclerView.Adapter<AdapterGallery.ViewHolder> {
    private final Context context;
    private final int[] fotoGallery;

    public AdapterGallery(Context context, int[] fotoGallery) {
        this.context = context;
        this.fotoGallery = fotoGallery;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gallery,parent, false);
        return new AdapterGallery.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(fotoGallery[position]);

    }

    @Override
    public int getItemCount() {
        return fotoGallery.length;
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull @NotNull View view) {
            super(view);
            imageView = view.findViewById(R.id.fotoGallery);
        }
    }
}
