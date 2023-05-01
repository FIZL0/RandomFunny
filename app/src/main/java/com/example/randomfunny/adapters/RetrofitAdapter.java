package com.example.randomfunny.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.randomfunny.R;
import com.example.randomfunny.networking.MemeResult;
import com.google.android.material.transition.Hold;

import org.jetbrains.annotations.NonNls;
import org.w3c.dom.Text;

import java.util.List;

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.HolderRetrofit> {

    Context mContext;
    List<MemeResult> memeResults;

    public RetrofitAdapter(Context mContext, List<MemeResult> memeResults){
        this.memeResults = memeResults;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HolderRetrofit onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_meme_image, parent, false);
        return new HolderRetrofit(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRetrofit holder, int position) {
        holder.memeText.setText(memeResults.get(position).getTitle());
        /**Glide.with(mContext).load(memeResults.get(position).getPreview())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground).into(holder.memeImage);
    */}

    @Override
    public int getItemCount() {
        return memeResults.size();
    }
    public class HolderRetrofit extends RecyclerView.ViewHolder {
        TextView memeText;
        ImageView memeImage;
        public HolderRetrofit(@NonNull View itemView) {
            super(itemView);
            memeImage = itemView.findViewById(R.id.memeImage);
            memeText = itemView.findViewById(R.id.memeText);
        }
    }
}
