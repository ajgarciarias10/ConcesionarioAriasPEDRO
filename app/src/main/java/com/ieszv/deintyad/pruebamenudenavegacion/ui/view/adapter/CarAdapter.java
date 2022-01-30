package com.ieszv.deintyad.pruebamenudenavegacion.ui.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.ieszv.deintyad.pruebamenudenavegacion.R;
import com.ieszv.deintyad.pruebamenudenavegacion.model.entity.Car;
import com.ieszv.deintyad.pruebamenudenavegacion.ui.view.adapter.viewholder.CarViewHolder;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder>{
    public  ArrayList<Car> cars = new ArrayList<>() ;
    private Context context;
    public CarAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return  new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = cars.get(position); //Obtenemos la posicion del coche
        //region Seteamos el texto
            holder.car = car;
            holder.titulo.setText(String.valueOf(car.getTitulo()));
            holder.ref.setText(String.valueOf(car.getRef()));
            holder.combustible.setText(car.getCombustible());
            holder.km.setText(String.valueOf(car.getKm()));
            holder.cambio.setText(car.getCambio());
            holder.potencia.setText(String.valueOf(car.getPotencia()));
            holder.año.setText(car.getAno());
            holder.precio.setText(String.valueOf(car.getPrecio()));
            Glide.with(context).load(car.getImagenes()).into(holder.ivCar);
        //enddregion

    }

    public int getItemCount() {
        if(cars == null){
            return 0;
        }
        return cars.size();
    }
    public void setCarList(ArrayList<Car> cars){
        this.cars = cars;
    }





}