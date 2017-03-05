/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.list.model;

/**
 *
 * @author FABAME
 */
public class Pelicula {

    private String nombre;
    private String director;
    private int anio;
    private String imagen;

    public Pelicula() {
        this.nombre = "";
        this.director = "";
        this.anio = 0;
        this.imagen = "";
    }

    public Pelicula(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
        this.anio = 0;
    }

    public Pelicula(String nombre, String director, int anio) {
        this.nombre = nombre;
        this.director = director;
        this.anio = anio;
    }

    public Pelicula(String nombre, String director, String imagen) {
        this.nombre = nombre;
        this.director = director;
        this.anio = 0;
        this.imagen = imagen;
    }

    public Pelicula(String nombre, String director, int anio, String imagen) {
        this.nombre = nombre;
        this.director = director;
        this.anio = anio;
        this.imagen = imagen;
    }

    public Pelicula(Pelicula pelicula) {
        this.nombre = pelicula.getNombre();
        this.director = pelicula.getDirector();
        this.anio = pelicula.getAnio();

    }

    public String getInformacion() {
        String img = "<img width='100' src='imagenes/../'" + this.imagen + "\" />";
        img = "";
        return img + this.nombre + " (Dirigida por " + this.director + ") [" + this.anio + "]";
    }

    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + ", director=" + director + ", anio=" + anio + ", imagen=" + imagen + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
