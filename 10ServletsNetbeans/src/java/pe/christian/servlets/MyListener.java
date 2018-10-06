/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.christian.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Christian
 */
@WebListener // Hace de la clase un servidor listener
public class MyListener implements ServletContextListener{

    // Permite inicializar el contexto de la aplicacion (lo comparten todos los servlets)
    @Override
    public void contextInitialized(ServletContextEvent sce) { 
        // Obtiene el contexto de la aplicacion para leer el web.xml
        ServletContext ctx = sce.getServletContext();
        String nombre = ctx.getInitParameter("basededatos"); // Se puede pasar cualquier objeto
        ctx.setAttribute("bd", nombre);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
