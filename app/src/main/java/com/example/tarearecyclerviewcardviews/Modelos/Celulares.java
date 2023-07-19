package com.example.tarearecyclerviewcardviews.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Celulares {
    private String id;
    private String titulo;
    private String precio;
    private String descripcion;

    private String urlcelular;

    private ArrayList<String> urlimages;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlcelular() {
        return urlcelular;
    }

    public void setUrlcelular(String urlcelular) {
        this.urlcelular = urlcelular;
    }

    public ArrayList<String> getUrlimages() {
        return urlimages;
    }

    public void setUrlimages(ArrayList<String> urlimages) {
        this.urlimages = urlimages;
    }

    public Celulares (JSONObject a)throws JSONException{
        id="TEL- "+a.getString("id").toString();
        titulo=a.getString("title").toString();
        precio="$ "+a.getString("price").toString()+".00";
        descripcion=a.getString("description").toString();
        urlcelular=a.getString("thumbnail").toString();
        JSONArray jImages =a.getJSONArray("images");
        urlimages = new ArrayList<String>();
        for (int i=0;i<=jImages.length()-1;i++)
        {
            //urlimages.add(jImages.getJSONObject(i).toString());
            urlimages.add(jImages.get(i).toString());
        }
    }
    public static ArrayList <Celulares> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Celulares> celulares=new ArrayList<>();
        for (int i=0;i<=datos.length()-1;i++)
        {
            celulares.add(new Celulares(datos.getJSONObject(i)));
        }
        return celulares;
    }
}
