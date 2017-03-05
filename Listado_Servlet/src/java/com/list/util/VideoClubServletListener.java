/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.list.util;

import com.list.model.Pelicula;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author FABAME
 */
public class VideoClubServletListener implements ServletContextListener {

    public VideoClubServletListener() {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Pelicula> listadoPeliculas = new LinkedList<>();
        listadoPeliculas.add(new Pelicula("Inception", "Nolan", 2010));
        listadoPeliculas.add(new Pelicula("Los Pitufos", "NN", 2011));
        listadoPeliculas.add(new Pelicula("Transformers 3", "Michael Bay", 2011));
        listadoPeliculas.add(new Pelicula("The Lord of the Rings", "Jackson", 2001));
        listadoPeliculas.add(new Pelicula("Be Kind Rewind", "Gondry", 2008));
        listadoPeliculas.add(new Pelicula("Ironman", "Jhon Favreau", 2008));
        listadoPeliculas.add(new Pelicula("Aliens", "Riddley Scott", 1979));
        listadoPeliculas.add(new Pelicula("Resident Evil", "Anderson", 2002));
        listadoPeliculas.add(new Pelicula("Kill Bill", "Tarantino", 2003));

        ServletContext contexto = sce.getServletContext();
        contexto.setAttribute("listadoPeliculas", listadoPeliculas);
        contexto.log("Se ha cargado el listado de peliculas.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
