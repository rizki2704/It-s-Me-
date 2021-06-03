package com.rizki.itsme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rizki.itsme.R;

import org.jetbrains.annotations.NotNull;

public class AdapterMusik extends RecyclerView.Adapter<AdapterMusik.ViewHolder> {
    // 2 Juni 2021, 10118025 Rizki Restu Illahi IF-1
    private final Context context;
    private final String[] musik;

    public AdapterMusik(Context context, String[] musik) {
        this.context = context;
        this.musik = musik;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_musik, parent, false);
        return new AdapterMusik.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.textView.setText(musik[position]);

    }

    @Override
    public int getItemCount() {
        return musik.length;
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull @NotNull View view) {
            super(view);
            textView = view.findViewById(R.id.musik);
        }
    }
}
