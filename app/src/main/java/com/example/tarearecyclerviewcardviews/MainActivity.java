package com.example.tarearecyclerviewcardviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tarearecyclerviewcardviews.Adaptadores.AdaptadorCelulares;
import com.example.tarearecyclerviewcardviews.Modelos.Celulares;
import com.example.tarearecyclerviewcardviews.WebServices.Asynchtask;
import com.example.tarearecyclerviewcardviews.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    RecyclerView recyclerViewCelulares;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCelulares=(RecyclerView) findViewById(R.id.lstTelefs);
        recyclerViewCelulares.setHasFixedSize(true);
        recyclerViewCelulares.setLayoutManager(new LinearLayoutManager(this));
        //recyclerViewCelulares.setLayoutManager(new GridLayoutManager(this,2));
        recyclerViewCelulares.setItemAnimator(new DefaultItemAnimator());

        Map<String, String> datos = new HashMap<>();
        WebService ws=new WebService("https://dummyjson.com/products",datos,MainActivity.this,MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Celulares> lstCelulares=new ArrayList<Celulares>();

        try {
            JSONObject JsonLista=new JSONObject(result);
            JSONArray JsonlistaCelulares= JsonLista.getJSONArray("products");
            lstCelulares=Celulares.JsonObjectsBuild(JsonlistaCelulares);


            int anima=R.anim.layout_animation_down_to_up;
            LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(getApplicationContext(),anima);
            recyclerViewCelulares.setLayoutAnimation(animationController);

           AdaptadorCelulares adaptadorCelulares = new AdaptadorCelulares(this,lstCelulares);
           recyclerViewCelulares.setAdapter(adaptadorCelulares);

        }
        catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

}