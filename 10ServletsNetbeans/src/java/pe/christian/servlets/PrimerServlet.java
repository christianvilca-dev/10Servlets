/*
 * Servlet
 * - Tecnologia de Java que permite la comunicacion via protocolo http entre el servidor y el cliente
 * - Permiten recibir peticiones, manejarlas y darle una respuesta al cliente
 * - En lo que se basan los framework's
 * - Procesan el GET

 * GET y POST 
 * - Hacen lo mismo
 * - Ambas viajan de forma plana
 * GET 
 * - Los parametros se envian en la url (Solicitud a una pagina)
 * POST
 * - Los parametros se envian en el cuerpo de la solicitud
 * - Se envia mas informacion en el request
 * - Antes se creia que protegia la informacion ( para hacerlo su usa el HTTPS)
 */
package pe.christian.servlets;

import java.io.IOException; // Para poder escribir en disco duro algunas cosas
import java.io.PrintWriter; // Nos permite devolver una respuesta escrita
import javax.servlet.ServletException; // Excepcion del servlet
import javax.servlet.annotation.WebServlet; // Nos evita escribir la informacion del servlet en el archivo web.xml
import javax.servlet.http.HttpServlet; // Clase en la que heredan los servlet
import javax.servlet.http.HttpServletRequest; // Solicitudes del cliente desde el html
import javax.servlet.http.HttpServletResponse; // Respuestas al cliente

/**
 *
 * @author Christian
 */
@WebServlet(name = "PrimerServlet", urlPatterns = {"/PrimerServlet"}) // Notacion que nos permite 
public class PrimerServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8"); // Tipo de contenido (respuesta)
        
        // Captura el valor del paramentro /PrimerServlet?nombre=55
        String nombre = request.getParameter("nombre");
        
        // En este try ya no es necesario el finally, por lo que se cierra automaticamente
        // Siempre y cuando se cree la clase autocerrable
        try (PrintWriter out = response.getWriter()) { // Se crea el objeto en el que se escribirá
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PrimerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hola " + nombre + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
