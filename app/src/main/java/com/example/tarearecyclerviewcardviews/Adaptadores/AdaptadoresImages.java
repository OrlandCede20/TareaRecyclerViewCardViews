package com.example.tarearecyclerviewcardviews.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tarearecyclerviewcardviews.Modelos.Celulares;
import com.example.tarearecyclerviewcardviews.R;

import java.util.List;

public class AdaptadoresImages extends RecyclerView.Adapter<AdaptadoresImages.CelularesViewHolder>{
    private Context Ctx;
    private List<String> lstImages;

    public AdaptadoresImages(Context Ctx2,List<String> imagesString)
    {
        this.lstImages=imagesString;
        Ctx=Ctx2;
    }

    @Override
    public AdaptadoresImages.CelularesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view=inflater.inflate(R.layout.lyitemviewimages,null);
        return new AdaptadoresImages.CelularesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadoresImages.CelularesViewHolder holder, int position) {
        String imagesCelulares=lstImages.get(position);
        Glide.with(Ctx).load(imagesCelulares).into(holder.imageViewImagesCelulares);

    }

    @Override
    public int getItemCount() {return lstImages.size();}

    class CelularesViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageViewImagesCelulares;
        public CelularesViewHolder(View itemView)
        {
            super(itemView);
            imageViewImagesCelulares=itemView.findViewById(R.id.imgImagesCelulares);
        }
    }
}
