package com.ieszv.deintyad.pruebamenudenavegacion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.ieszv.deintyad.pruebamenudenavegacion.databinding.ActivityMainBinding;
import com.ieszv.deintyad.pruebamenudenavegacion.model.entity.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    //region inicion conexion bd
    /**
     * REALIZANDO CONEXION CON LA BD
     */
    private static final String URL = "jdbc:mysql://146.59.237.189:3306/dam208_ajgaconcesionario";
    private static final String USER = "dam208_ajga";
    private static final String PASSWORD = "dam208_ajga";
    public static ArrayList<Car> cars = new ArrayList<>() ;

    //endregion
    //region Metodo onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);
        obtainCars();

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_contacto)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    //region OBTENCION DATOS DE LA BASE DE DATOS CONSULTA PARA OBTENER TODOS LOS carS
    public Connection conectoToTheDataBase() throws Exception {
        Connection cnn=null;
        StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(politica);
        Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        cnn = DriverManager.getConnection(URL,USER,PASSWORD);
        return cnn;

    }
    public void obtainCars(){
        try{
            Statement stm = conectoToTheDataBase().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM coches");
            while(rs.next()){
                Car car = new Car();
                car.setRef(Integer.parseInt(rs.getString(1)));
                car.setCombustible(rs.getString(2));
                car.setKm(Integer.parseInt(rs.getString(3)));
                car.setCambio(rs.getString(4));
                car.setPotencia(Integer.parseInt(rs.getString(5)));
                car.setNpuertas(Integer.parseInt(rs.getString(6)));
                car.setColor(rs.getString(7));
                car.setAno(rs.getString(8));
                car.setTitulo(rs.getString(9));
                car.setDescripcion(rs.getString(10));
                car.setUrl(rs.getString(11));
                car.setImagenes(obtainImagenNº1(rs.getString(12)));
                car.setPrecio((rs.getString(13)));
                car.setLocalizacion(rs.getString(14));
                car.setTodaslasfotos(obtenerImagenes(rs.getString(12)));
                //Adding car to the arrayList
                cars.add(car);
                Log.v("adad",car.toString());
                car = null;
            }

        }catch(Exception e){
        }
    }

    //endregion

        private String obtainImagenNº1(String imagenes) {
            //Creamos el array
            String[] imagenesSinPuntosComas;
            //Separamos el String de todas las fotos separadas con ';'
            imagenesSinPuntosComas = imagenes.split(";");

            //Devolvemos solo la primera en este caso
            return imagenesSinPuntosComas[0];

        }
        private String[] obtenerImagenes(String imagenes) {
            String[] imagenesSinPuntosComas;

            imagenesSinPuntosComas = imagenes.split(";");
            return imagenesSinPuntosComas;
        }

    //endregion

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}