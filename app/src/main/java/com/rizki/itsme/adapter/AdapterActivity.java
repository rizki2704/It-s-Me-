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

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.ViewHolder> {
    // 1 Juni 2021, 10118025 Rizki Restu Illahi IF-1
    private final Context context;
    private final String[] SubjectValues;
    private final int[] gambar_act;

    public AdapterActivity(Context context, String[] subjectValues, int[] gambar_act) {
        this.context = context;
        SubjectValues = subjectValues;
        this.gambar_act = gambar_act;
    }


    @NotNull
    @Override
    public AdapterActivity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(gambar_act[position]);
        holder.textView.setText(SubjectValues[position]);

    }

    @Override
    public int getItemCount() {
        return SubjectValues.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        ViewHolder(View view) {
            super(view);

            imageView = view.findViewById(R.id.imageItem);
            textView = view.findViewById(R.id.textItem);
        }
    }
}
