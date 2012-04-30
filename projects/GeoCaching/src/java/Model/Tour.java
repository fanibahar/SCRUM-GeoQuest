/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beatriz
 */
public class Tour {

    private int sTourId;
    private String sName;
    private String sDescription;
    private String sDifficulty;
    private List<Waypoint> pWaypoints = new ArrayList<Waypoint>();

    public Tour() {
    }

    public Tour(int idtour, String name, String description, String difficulty) {
        this.sTourId = idtour;
        this.sName = name;
        this.sDescription = description;
        this.sDifficulty = difficulty;
    }

    /**
     * Get the value of idtour
     *
     * @return the value of idtour
     */
    public int getTourId() {
        return sTourId;
    }

    /**
     * Set the value of idtour
     *
     * @param idtour new value of idtour
     */
    public void setTourId(int idtour) {
        this.sTourId = idtour;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getTourName() {
        return sName;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setTourName(String name) {
        this.sName = name;
    }

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getTourDescription() {
        return sDescription;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setTourDescription(String description) {
        this.sDescription = description;
    }

    /**
     * Get the value of difficulty
     *
     * @return the value of difficulty
     */
    public String getTourDifficulty() {
        return sDifficulty;
    }

    /**
     * Set the value of difficulty
     *
     * @param difficulty new value of difficulty
     */
    public void setTourDifficulty(String difficulty) {
        this.sDifficulty = difficulty;
    }

    /**
     * Get the value of waypoints
     *
     * @return the value of waypoints
     */
    public List<Waypoint> getTourWaypoints() {
        return pWaypoints;
    }

    /**
     * Set the value of waypoints
     *
     * @param waypoints new value of waypoints
     */
    public void setTourWaypoints(List<Waypoint> waypoints) {
        this.pWaypoints = waypoints;
    }

    public void addWaypoint(Waypoint waypoint) {
        pWaypoints.add(waypoint);
    }

    public Waypoint getWaypointByPosition(int nPos) {
        return pWaypoints.get(nPos);
    }

    public int getWaypointCount() {
        return pWaypoints.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tour other = (Tour) obj;
        if (this.sTourId != other.sTourId) {
            return false;
        }
        if ((this.sName == null) ? (other.sName != null) : !this.sName.equals(other.sName)) {
            return false;
        }
        if ((this.sDescription == null) ? (other.sDescription != null) : !this.sDescription.equals(other.sDescription)) {
            return false;
        }
        if ((this.sDifficulty == null) ? (other.sDifficulty != null) : !this.sDifficulty.equals(other.sDifficulty)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
}
