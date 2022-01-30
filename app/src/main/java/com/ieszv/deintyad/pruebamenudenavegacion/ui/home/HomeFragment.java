package com.ieszv.deintyad.pruebamenudenavegacion.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ieszv.deintyad.pruebamenudenavegacion.MainActivity;
import com.ieszv.deintyad.pruebamenudenavegacion.databinding.FragmentHomeBinding;
import com.ieszv.deintyad.pruebamenudenavegacion.model.entity.Car;
import com.ieszv.deintyad.pruebamenudenavegacion.ui.view.adapter.CarAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //region  SETEAR EL ADAPTADOR
        binding.rvCar.setLayoutManager(new LinearLayoutManager(getContext()));
        CarAdapter carAdapter = new CarAdapter(getContext());
        binding.rvCar.setAdapter(carAdapter);
        ArrayList<Car> cars = MainActivity.cars ;
        carAdapter.setCarList(cars);
        //endregion

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}