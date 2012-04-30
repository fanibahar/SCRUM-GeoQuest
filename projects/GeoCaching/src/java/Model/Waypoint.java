/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Beatriz
 */
public class Waypoint {

    private int waypointid;
    private int tourid;
    private String name;
    private String latitude;
    private String longitude;
    private boolean bFinal;
    private int position;

    public Waypoint() {
    }

    public Waypoint(int waypointid, int tourid, String name, String latitude, String longitude, boolean bFinal, int position) {
        this.waypointid = waypointid;
        this.tourid = tourid;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.bFinal = bFinal;
        this.position = position;
    }    
    
    /**
     * Get the value of waypointid
     *
     * @return the value of waypointid
     */
    public int getWaypointId() {
        return waypointid;
    }

    /**
     * Set the value of waypointid
     *
     * @param waypointid new value of waypointid
     */
    public void setWaypointId(int waypointid) {
        this.waypointid = waypointid;
    }

    /**
     * Get the value of tourid
     *
     * @return the value of tourid
     */
    public int getTourId() {
        return tourid;
    }

    /**
     * Set the value of tourid
     *
     * @param tourid new value of tourid
     */
    public void setTourId(int tourid) {
        this.tourid = tourid;
    }

    
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getWaypointName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setWaypointName(String name) {
        this.name = name;
    }
    
        /**
     * Get the value of latitude
     *
     * @return the value of latitude
     */
    public String getWaypointLatitude() {
        return latitude;
    }

    /**
     * Set the value of latitude
     *
     * @param latitude new value of latitude
     */
    public void setWaypointLatitude(String latitude) {
        this.latitude = latitude;
    }

        /**
     * Get the value of longitude
     *
     * @return the value of longitude
     */
    public String getWaypointLongitude() {
        return longitude;
    }

    /**
     * Set the value of longitude
     *
     * @param longitude new value of longitude
     */
    public void setWaypointLongitude(String longitude) {
        this.longitude = longitude;
    }
    
        /**
     * Get the value of bFinal
     *
     * @return the value of bFinal
     */
    public boolean getIsWaypointFinal() {
        return bFinal;
    }

    /**
     * Set the value of bFinal
     *
     * @param bFinal new value of bFinal
     */
    public void setIsWaypointFinal(boolean bFinal) {
        this.bFinal = bFinal;
    }

        /**
     * Get the value of position
     *
     * @return the value of position
     */
    public int getWaypointPosition() {
        return position;
    }

    /**
     * Set the value of position
     *
     * @param position new value of position
     */
    public void setWaypointPosition(int position) {
        this.position = position;
    }
    
    @Override
    public String toString()
    {
        return name + ", " + latitude + ", " + longitude;
    }

}
