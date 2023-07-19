package com.example.tarearecyclerviewcardviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tarearecyclerviewcardviews.Adaptadores.AdaptadorCelulares;
import com.example.tarearecyclerviewcardviews.Adaptadores.AdaptadoresImages;
import com.example.tarearecyclerviewcardviews.Modelos.Celulares;
import com.example.tarearecyclerviewcardviews.WebServices.Asynchtask;
import com.example.tarearecyclerviewcardviews.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivityImage extends AppCompatActivity{

    RecyclerView recyclerViewImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_image);
        recyclerViewImages=(RecyclerView) findViewById(R.id.lstImages);
        recyclerViewImages.setHasFixedSize(true);
        recyclerViewImages.setLayoutManager(new GridLayoutManager(this,2));
        recyclerViewImages.setItemAnimator(new DefaultItemAnimator());
        Bundle bimages=this.getIntent().getExtras();
        ArrayList<String> aimages= bimages.getStringArrayList("images");


        AdaptadoresImages adaptadoresImages = new AdaptadoresImages(this,aimages);
        recyclerViewImages.setAdapter(adaptadoresImages);
    }
}