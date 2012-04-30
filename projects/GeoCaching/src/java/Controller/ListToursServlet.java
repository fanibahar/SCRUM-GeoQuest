/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DatabaseMethods.CreateTourDatabaseMethods;
import Model.Tour;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author Beatriz
 */
public class ListToursServlet extends HttpServlet {

    // This is to access the Model Classes (DB)
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;

    // Copy this piece 4 instruction where you need to have the list of tours to display it.
    private void ThisMethodHasHowYouWillGetTheListOfToursFromTheDatabase() throws ServletException {
        EntityManager em = StartDBTransaction();
        CreateTourDatabaseMethods createTourLogic = new CreateTourDatabaseMethods(em);

        // This variable has the list of tours
        List<Tour> allTours = createTourLogic.GetAllTours();

        // Always need to end with this call.
        EndDBTransaction(em);
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListToursServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListToursServlet at " + request.getContextPath() + "</h1>");
            
            ThisMethodHasHowYouWillGetTheListOfToursFromTheDatabase();
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
    
    // Begins a transaction using utx because we are using JTA EM.
    private EntityManager StartDBTransaction() throws ServletException {
        try {
            utx.begin();
        } catch (Exception e) {
            throw new ServletException(e);
        }
        EntityManager em = emf.createEntityManager();
        return em;
    }

    // Makes effective the change in the DB
    private void EndDBTransaction(EntityManager em) {
        try {
            utx.commit();
        } catch (Exception ex) {
            int i = 2;
            i = 3;
        } finally {
            em.close();
        }
    }
}
