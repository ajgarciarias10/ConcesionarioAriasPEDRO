package com.ieszv.deintyad.pruebamenudenavegacion.ui.view.adapter.viewholder;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.ieszv.deintyad.pruebamenudenavegacion.R;
import com.ieszv.deintyad.pruebamenudenavegacion.model.entity.Car;


public class CarViewHolder extends RecyclerView.ViewHolder{
    public TextView ref, combustible, km, cambio, potencia,color,año,titulo,precio;
    public ImageView ivCar;
    public Car car;
    private Bundle bundle;
    public CarViewHolder(@NonNull View itemView) {
        super(itemView);
        ref = itemView.findViewById(R.id.tv_referencia);
        combustible = itemView.findViewById(R.id.tv_gasofa);
        km = itemView.findViewById(R.id.tv_km);
        cambio = itemView.findViewById(R.id.tv_cambio);
        potencia = itemView.findViewById(R.id.tv_potencia);
        año = itemView.findViewById(R.id.tv_fecha);
        precio =itemView.findViewById(R.id.tv_pujamin);
        titulo= itemView.findViewById(R.id.tv_titulo);
        ivCar = itemView.findViewById(R.id.iv_coche);
        itemView.setOnClickListener(v -> {
            bundle = new Bundle();
            bundle.putParcelable("Concesionario", car);
            Navigation.findNavController(itemView).navigate(R.id.action_nav_home_to_verCocheFragment,bundle);

        });

    }
}