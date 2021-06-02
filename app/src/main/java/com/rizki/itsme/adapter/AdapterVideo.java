package com.rizki.itsme.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rizki.itsme.R;

import org.jetbrains.annotations.NotNull;

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.ViewHolder> {
    private final Context context;
    private final String[] video;
    private final String[] judulVideo;

    public AdapterVideo(Context context, String[] video, String[] judulVideo) {
        this.context = context;
        this.video = video;
        this.judulVideo = judulVideo;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        return new AdapterVideo.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.videoView.setVideoURI(Uri.parse(video[position]));

        MediaController mc = new MediaController(context);
        mc.setAnchorView(holder.videoView);
        mc.setMediaPlayer(holder.videoView);
        holder.videoView.setMediaController(mc);
        holder.textView.setText(judulVideo[position]);

    }

    @Override
    public int getItemCount() {
        return video.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        TextView textView;

        public ViewHolder(@NonNull @NotNull View view) {
            super(view);
            videoView = view.findViewById(R.id.video);
            textView = view.findViewById(R.id.judulVideo);
        }
    }
}
