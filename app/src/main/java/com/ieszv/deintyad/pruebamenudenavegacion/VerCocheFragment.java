package com.ieszv.deintyad.pruebamenudenavegacion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.ieszv.deintyad.pruebamenudenavegacion.databinding.FragmentVerCocheBinding;
import com.ieszv.deintyad.pruebamenudenavegacion.model.entity.Car;

import java.util.ArrayList;

public class VerCocheFragment extends Fragment {

    private Car car;
    private FragmentVerCocheBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentVerCocheBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //region Recogemos lo que se pasa del viewHolder

        Bundle bundle = new Bundle();
        bundle = getArguments();
        car = bundle.getParcelable("Concesionario");
        binding.tvTituloItem.setText(car.getTitulo());
        binding.tvAOItem.setText("Año: "+ "\n" +car.getAno());
        binding.tvCambioItem.setText("Cambio: "+ "\n" +car.getCambio());
        binding.tvCombustibleItem.setText("Tipo de Combustible: "+ "\n" +car.getCombustible());
        binding.tvKmItem.setText("Km: "+ "\n" +String.valueOf(car.getKm())+ "km");
        binding.tvLocalizacionItem.setText("Localizacion: "+ "\n" + car.getLocalizacion());
        binding.tvPotenciaItem.setText("Potencia: "+ "\n" +String.valueOf(car.getPotencia())+ "cv");
        binding.tvNumeroPuertasItem.setText("Numero de Puertas: "+ "\n" + String.valueOf(car.getNpuertas())+ "puertas");
        binding.tvReferencia2.setText(String.valueOf("Referencia: "+ "\n" + car.getRef()));
        binding.tvPujaminima.setText("Precio: "+ "\n"+String.valueOf(car.getPrecio()) + "€");
        binding.tvDescripcion.setText( "Descripcion: " + "\n"+ car.getDescripcion());
        ///TUTORIAL  https://www.youtube.com/watch?v=cxCOZxO9YaA&t=183s
        String[] imagenes = car.getTodaslasfotos();
        ArrayList<SlideModel> imagenesPordios = new ArrayList<>();
        //Bucle para sacar todas las imagenes
        for (int i = 0; i < imagenes.length; i++) {
            imagenesPordios.add(new SlideModel(imagenes[i],"Nº de imagenes:" + (i+1) + "/" + imagenes.length  , ScaleTypes.CENTER_CROP));
            binding.imageSlider.setImageList(imagenesPordios);

        }


        //endregion

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}