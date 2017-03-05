/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.list.controller;

import com.list.model.Pelicula;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FABAME
 */
@WebServlet(urlPatterns = {"/guardarPelicula", "/guardarPelicula.do"})
public class ServletGuardarPelicula extends HttpServlet {

    public ServletGuardarPelicula() {

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            /* TODO output your page here. You may use following sample code. */
            List<String> listadoMensajesError = new LinkedList<>();
            request.setAttribute("listadoMensajesError", listadoMensajesError);

            try {
                String nombre = request.getParameter("nombre").trim();
                String director = request.getParameter("director").trim();
                String anioString = request.getParameter("anio").trim();

                // Validaciones.
                int anio = -1;
                try {
                    anio = Integer.parseInt(anioString);
                } catch (NumberFormatException ex) {
                    listadoMensajesError.add("El Año debe ser un número entero positivo.");
                }

                // Verificamos los parametros.
                if (nombre.length() == 0) {
                    listadoMensajesError.add("Debe ingresar un nombre.");
                }

                if (director.length() == 0) {
                    listadoMensajesError.add("Debe ingresar un director.");
                }

                if ((anio != -1) && (anio < 1900) || anio > 2016) {
                    listadoMensajesError.add("El Año debe estar entre 1900 y 2016.");
                }

                if (!listadoMensajesError.isEmpty()) {
                    out.println("ERRORES");
                    request.setAttribute("listadoMensajesError", listadoMensajesError);
                    RequestDispatcher view = request.getRequestDispatcher("/formAgregarPelicula.view");
                    view.forward(request, response);
                    return;

                    // Si no hay errores.
                } else {
                    Pelicula pelicula = new Pelicula(nombre, director, anio);
                    request.setAttribute("pelicula", pelicula);

                    ServletContext contexto = this.getServletContext();
                    List<Pelicula> listadoPeliculas = (List<Pelicula>) contexto.getAttribute("listadoPeliculas");
                    listadoPeliculas.add(pelicula);

                    RequestDispatcher view = request.getRequestDispatcher("/listadoPeliculas.view");
                    view.forward(request, response);
                    return;
                }

            } catch (Exception ex) {
                listadoMensajesError.add(ex.getMessage());
                ex.printStackTrace();
            }

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
