/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseMethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Beatriz
 */
public class CreateTourDatabaseMethods {

    EntityManager em;

    public CreateTourDatabaseMethods(EntityManager em) {
        this.em = em;
    }

    private Model.Tour PassDBTourToModelTour(DatabaseClasses.Tour dbTour) {
        Model.Tour mTour = new Model.Tour(
                dbTour.getIdtour(),
                dbTour.getName(),
                dbTour.getDescription(),
                dbTour.getDifficulty());

        for (DatabaseClasses.Waypoint dbWaypoint : dbTour.getWaypointCollection()) {
            Model.Waypoint mWaypoint = new Model.Waypoint(
                    dbWaypoint.getWaypointPK().getIdwaypoint(),
                    dbWaypoint.getWaypointPK().getFkIdtour(),
                    dbWaypoint.getName(),
                    dbWaypoint.getLatitude(),
                    dbWaypoint.getLongitude(),
                    dbWaypoint.getFinal1(),
                    dbWaypoint.getOrderPosition());

            mTour.addWaypoint(mWaypoint);
        }

        return mTour;
    }

    /////////////////
    // GET Methods //
    /////////////////
    public ArrayList<Model.Tour> GetAllTours() {
        List<DatabaseClasses.Tour> dbTours = (List<DatabaseClasses.Tour>) em.createNamedQuery("Tour.findAll").getResultList();
        List<Model.Tour> mTours = new ArrayList<Model.Tour>();

        for (DatabaseClasses.Tour dbTour : dbTours) {
            Model.Tour mTour = PassDBTourToModelTour(dbTour);
            mTours.add(mTour);
        }

        return (ArrayList<Model.Tour>) mTours;
    }

    public Model.Tour GetTourById(int nTourId) {
        DatabaseClasses.Tour dbTour = (DatabaseClasses.Tour) em.createNamedQuery("Tour.findByIdtour").setParameter("idtour", nTourId).getResultList().get(0);
        return PassDBTourToModelTour(dbTour);
    }

    public ArrayList<Model.Waypoint> GetAllWaypointsByTourId(int nTourId) {
        List<DatabaseClasses.Waypoint> dbWaypoints = (List<DatabaseClasses.Waypoint>) em.createNamedQuery("Waypoint.findByFkIdtour").setParameter("fkIdtour", nTourId).getResultList();

        ArrayList<Model.Waypoint> mWaypoints = new ArrayList<Model.Waypoint>();

        for (DatabaseClasses.Waypoint dbWaypoint : dbWaypoints) {
            Model.Waypoint mWaypoint = new Model.Waypoint(
                    dbWaypoint.getWaypointPK().getIdwaypoint(),
                    dbWaypoint.getWaypointPK().getFkIdtour(),
                    dbWaypoint.getName(),
                    dbWaypoint.getLatitude(),
                    dbWaypoint.getLongitude(),
                    dbWaypoint.getFinal1(),
                    dbWaypoint.getOrderPosition());

            mWaypoints.add(mWaypoint);
        }

        return mWaypoints;
    }

    ////////////////////
    // INSERT Methods //
    ////////////////////
    public int InsertTour(Model.Tour mTour) {

        int nLastTourId;
        try {
            nLastTourId = Integer.parseInt((em.createNamedQuery("Tour.getLastTourId").getResultList().get(0)).toString());
        } catch (Exception e) {
            nLastTourId = 0;
        }

        DatabaseClasses.Tour dbTour = new DatabaseClasses.Tour(nLastTourId + 1);
        dbTour.setName(mTour.getTourName());
        dbTour.setDescription(mTour.getTourDescription());
        dbTour.setDifficulty(mTour.getTourDifficulty());

        em.persist(dbTour);

        int nTourId = Integer.parseInt((em.createNamedQuery("Tour.getLastTourId").getResultList().get(0)).toString());

        return nTourId;
    }

    public int InsertWaypointToTour(int nTourId, Model.Waypoint mWaypoint) {
        int nLastWaypointId;
        try {
            nLastWaypointId = Integer.parseInt((em.createNamedQuery("Waypoint.getLastWaypointId").getResultList().get(0)).toString());
        } catch (Exception e) {
            nLastWaypointId = 0;
        }

        DatabaseClasses.Waypoint dbWaypoint = new DatabaseClasses.Waypoint(nLastWaypointId + 1, nTourId);

        dbWaypoint.setName(mWaypoint.getWaypointName());
        dbWaypoint.setLatitude(mWaypoint.getWaypointLatitude());
        dbWaypoint.setLongitude(mWaypoint.getWaypointLongitude());
        dbWaypoint.setFinal1(mWaypoint.getIsWaypointFinal());
        dbWaypoint.setOrderPosition(mWaypoint.getWaypointPosition());

        em.persist(dbWaypoint);
        return dbWaypoint.getWaypointPK().getIdwaypoint();
    }

    ////////////////////
    // UPDATE Methods //
    ////////////////////
    public void EditTourProperties(Model.Tour mTour) {
        DatabaseClasses.Tour dbTour = em.find(DatabaseClasses.Tour.class, mTour.getTourId());
        dbTour.setName(mTour.getTourName());
        dbTour.setDescription(mTour.getTourDescription());
        dbTour.setDifficulty(mTour.getTourDifficulty());
    }

    public void EditWaypointOfTour(Model.Waypoint mWaypoint) {
        DatabaseClasses.Waypoint dbWaypoint = em.find(DatabaseClasses.Waypoint.class,
                new DatabaseClasses.WaypointPK(mWaypoint.getWaypointId(), mWaypoint.getTourId()));

        dbWaypoint.setName(mWaypoint.getWaypointName());
        dbWaypoint.setLatitude(mWaypoint.getWaypointLatitude());
        dbWaypoint.setLongitude(mWaypoint.getWaypointLongitude());
        dbWaypoint.setOrderPosition(mWaypoint.getWaypointPosition());
        dbWaypoint.setFinal1(mWaypoint.getIsWaypointFinal());
    }
}
