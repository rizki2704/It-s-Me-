package com.rizki.itsme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rizki.itsme.R;

import org.jetbrains.annotations.NotNull;

public class AdapterFriends extends RecyclerView.Adapter<AdapterFriends.ViewHolder> {
    private final Context context;
    private final String[] SubjectValues;
    private final int[] fotoT;

    public AdapterFriends(Context context, String[] subjectValues, int[] fotoT) {
        this.context = context;
        SubjectValues = subjectValues;
        this.fotoT = fotoT;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_friends, parent, false);
        return new AdapterFriends.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(fotoT[position]);
        holder.textView.setText(SubjectValues[position]);

    }

    @Override
    public int getItemCount() {
        return SubjectValues.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull @NotNull View view) {
            super(view);
            imageView = view.findViewById(R.id.profileT);
            textView = view.findViewById(R.id.namaT);
        }
    }
}
