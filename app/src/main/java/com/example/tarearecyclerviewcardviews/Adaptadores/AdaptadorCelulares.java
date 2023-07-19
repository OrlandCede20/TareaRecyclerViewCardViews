package com.example.tarearecyclerviewcardviews.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tarearecyclerviewcardviews.MainActivity;
import com.example.tarearecyclerviewcardviews.MainActivityImage;
import com.example.tarearecyclerviewcardviews.Modelos.Celulares;
import com.example.tarearecyclerviewcardviews.R;

import java.util.List;

public class AdaptadorCelulares extends RecyclerView.Adapter<AdaptadorCelulares.CelularesViewHolder> {
    private Context Ctx;
    private List<Celulares> lstCelulares;
    public AdaptadorCelulares(Context Ctx2,List<Celulares> celulares)
    {
        this.lstCelulares=celulares;
        Ctx=Ctx2;
    }

    @Override
    public CelularesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view=inflater.inflate(R.layout.lyitemview,null);
        return new CelularesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCelulares.CelularesViewHolder holder, int position) {
        Celulares celulares=lstCelulares.get(position);
        holder.textViewID.setText(celulares.getId());
        holder.textViewTitle.setText(celulares.getTitulo());
        holder.textViewPrice.setText(celulares.getPrecio());
        holder.textViewDescription.setText(celulares.getDescripcion());
        Glide.with(Ctx).load(celulares.getUrlcelular()).into(holder.imageViewCelulares);
        holder.imageViewCelulares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ctx, MainActivityImage.class);
                Bundle b = new Bundle();
                b.putStringArrayList("images", celulares.getUrlimages());
                intent.putExtras(b);
                Ctx.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {return lstCelulares.size();}

    class CelularesViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewID,textViewTitle,textViewPrice,textViewDescription,textViewUrlImagen;
        ImageView imageViewCelulares,imageViewImagesCelulares;
        public CelularesViewHolder(View itemView)
        {
            super(itemView);
            textViewID=itemView.findViewById(R.id.txtId);
            textViewTitle=itemView.findViewById(R.id.txtTitle);
            textViewPrice=itemView.findViewById(R.id.txtPrice);
            textViewDescription=itemView.findViewById(R.id.txtDescription);
            textViewUrlImagen=itemView.findViewById(R.id.txtUrlimagen);
            imageViewCelulares=itemView.findViewById(R.id.imgCeular);
            imageViewImagesCelulares=itemView.findViewById(R.id.imgImagesCelulares);
        }
    }
}
