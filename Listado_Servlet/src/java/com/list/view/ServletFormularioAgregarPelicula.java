/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.list.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FABAME
 */
@WebServlet(urlPatterns = {"/formAgregarPelicula", "/formAgregarPelicula.view", "/agregarPelicula", "/agregarPelicula.view"})
public class ServletFormularioAgregarPelicula extends HttpServlet {

    public ServletFormularioAgregarPelicula() {

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
            List<String> listadoMensajesError = (List<String>) request.getAttribute("listadoMensajesError");
            String htmlErrores = "";

            if (listadoMensajesError != null) {
                htmlErrores = "<font color='red'><p>ERRORES ENCONTRADOS.</p></font>";

                Iterator<String> iterator = listadoMensajesError.iterator();
                while (iterator.hasNext()) {
                    String error = (String) iterator.next();
                    htmlErrores += "<font color='red'><li>" + error + "</li></font>";
                }

            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Agregar Película</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Agregar Película</h1>");

            out.println(htmlErrores);

            String nombre = request.getParameter("nombre");
            String anio = request.getParameter("anio");
            String director = request.getParameter("director");

            if (nombre == null) {
                nombre = "";
            }

            if (anio == null) {
                anio = "";
            }

            if (director == null) {
                director = "";
            }

            out.println("<form name='form1' action='guardarPelicula.do' method='POST'>");

            out.println("<table>");

            out.println("<thead>");

            out.println("<tr>");
            out.println("<th></th>");
            out.println("<th></th>");
            out.println("<th></th>");
            out.println("<th></th>");
            out.println("</tr>");

            out.println("</thead>");

            out.println("<tbody>");

            out.println("<tr>");
            out.println("<td><p>Nombre:</p></td><td><input type='text' name='nombre' value='" + nombre + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td><p>Director:</p></td><td><input type='text' name='director' value='" + director + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td><p>Año:</p></td><td><input type='text' name='anio' value='" + anio + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td><input type='submit' name='guardar' value='GUARDAR'></td>");
            out.println("</tr>");

            out.println("</tbody>");

            out.println("</table>");

            out.println("</form>");

            out.println("<h2><a href='index.jsp'>[VOLVER]</a></h2>");
            out.println("</body>");
            out.println("</html>");

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
