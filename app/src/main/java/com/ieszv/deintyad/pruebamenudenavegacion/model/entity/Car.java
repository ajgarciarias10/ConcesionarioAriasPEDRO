package com.ieszv.deintyad.pruebamenudenavegacion.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements  Parcelable {

    public int ref;

    public String combustible;
    public int km;
    public String cambio;
    public int potencia;
    public int npuertas;
    public String ano;
    public String color;
    public String titulo;
    public String descripcion;
    public String imagenes;
    public String precio;
    public String localizacion;
    public String url;
   public String [] todaslasfotos;

    public Car() {
    }

    public Car(int ref, String combustible, int km, String cambio, int potencia, int npuertas, String ano, String color, String titulo, String descripcion, String imagenes, String precio, String localizacion, String url, String[] todaslasfotos) {
        this.ref = ref;
        this.combustible = combustible;
        this.km = km;
        this.cambio = cambio;
        this.potencia = potencia;
        this.npuertas = npuertas;
        this.ano = ano;
        this.color = color;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenes = imagenes;
        this.precio = precio;
        this.localizacion = localizacion;
        this.url = url;
        this.todaslasfotos = todaslasfotos;
    }

    protected Car(Parcel in) {
        ref = in.readInt();
        combustible = in.readString();
        km = in.readInt();
        cambio = in.readString();
        potencia = in.readInt();
        npuertas = in.readInt();
        ano = in.readString();
        color = in.readString();
        titulo = in.readString();
        descripcion = in.readString();
        imagenes = in.readString();
        precio = in.readString();
        localizacion = in.readString();
        url = in.readString();
        todaslasfotos = in.createStringArray();
    }


    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public int getRef() {
        return ref;
    }

    public String getCombustible() {
        return combustible;
    }

    public int getKm() {
        return km;
    }

    public String getCambio() {
        return cambio;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getNpuertas() {
        return npuertas;
    }

    public String getAno() {
        return ano;
    }

    public String getColor() {
        return color;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagenes() {
        return imagenes;
    }

    public String getPrecio() {
        return precio;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public String getUrl() {
        return url;
    }

    public String[] getTodaslasfotos() {
        return todaslasfotos;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setNpuertas(int npuertas) {
        this.npuertas = npuertas;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTodaslasfotos(String[] todaslasfotos) {
        this.todaslasfotos = todaslasfotos;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ref);
        dest.writeString(combustible);
        dest.writeInt(km);
        dest.writeString(cambio);
        dest.writeInt(potencia);
        dest.writeInt(npuertas);
        dest.writeString(ano);
        dest.writeString(color);
        dest.writeString(titulo);
        dest.writeString(descripcion);
        dest.writeString(imagenes);
        dest.writeString(precio);
        dest.writeString(localizacion);
        dest.writeString(url);
        dest.writeStringArray(todaslasfotos);
    }
}