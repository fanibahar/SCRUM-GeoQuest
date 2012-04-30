/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ilyakostrikov
 */
public class Tour {
    private List<Waypoint> waypoints;
    
    public Tour()
    {
        waypoints = new ArrayList<Waypoint>();
    }
    
    public void addWaypoint(Waypoint waypoint)
    {
        waypoints.add(waypoint);
        //FIXIT. Add a copy
    }
    
    public Waypoint getWaypoint(int i)
    {
        return waypoints.get(i);
        //FIXIT. Return a copy
    }
    
    public int size()
    {
        return waypoints.size();
    }
    
}
