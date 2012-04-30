/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DatabaseMethods.CreateTourDatabaseMethods;
import Model.Tour;
import Model.Waypoint;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author Beatriz
 */
@WebServlet(name = "CreateTourServlet", urlPatterns = {"/CreateTourServlet"})
public class CreateTourServlet extends HttpServlet {

    // This is to access the Model Classes (DB)
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;

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
    Tour tour = new Tour();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            if (request.getQueryString().contains("addwaypoint")) {
                String latitude_ = extractLatitude(request);
                String longtitude_ = extractLongtitude(request);
                
                String name = request.getParameter("name");
                                
                tour.addWaypoint(new Waypoint(tour.getWaypointCount(), 1, name, latitude_, longtitude_, false, tour.getWaypointCount()));
                printListOfWaypoints(out);
            }
            else if (request.getQueryString().contains("addtour")) {
                addTourToDatabase(request);
                out.println("<br/>The tour is saved!");
            }

        } finally {
            out.close();
        }
    }

    private void addTourToDatabase(HttpServletRequest request) throws ServletException {
        // Always need to start with these two instructions
        String level = request.getParameter("level");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        tour.setTourDifficulty(level);
        tour.setTourName(name);
        tour.setTourDescription(description);
        
        EntityManager em = StartDBTransaction();
        CreateTourDatabaseMethods createTourLogic = new CreateTourDatabaseMethods(em);

        int nTourId = createTourLogic.InsertTour(tour);

        for (Waypoint waypoint1 : tour.getTourWaypoints()) {
            createTourLogic.InsertWaypointToTour(nTourId, waypoint1);
        }

        // Always need to end with this call.
        EndDBTransaction(em);

        tour = new Tour();
    }

    private void printListOfWaypoints(PrintWriter out) {
        for (int i = 0; i < tour.getWaypointCount(); i++)
            out.println("<br/>Waypoint " + Integer.toString(i) + ": " + tour.getWaypointByPosition(i));
    }

    private String extractLongtitude(HttpServletRequest request) {
        String coordinates = request.getParameter("addwaypoint");
        
        int rightBracket = coordinates.indexOf(")");
        int comma = coordinates.indexOf(",");
        
        String longtitude_ = coordinates.substring(comma + 4, rightBracket);
        return longtitude_;
    }

    private String extractLatitude(HttpServletRequest request) {
        String coordinates = request.getParameter("addwaypoint");
        
        int leftBracket = coordinates.indexOf("(");
        int comma = coordinates.indexOf(",");

        String latitude_ = coordinates.substring(leftBracket + 1, comma - 1);
        return latitude_;
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
}
