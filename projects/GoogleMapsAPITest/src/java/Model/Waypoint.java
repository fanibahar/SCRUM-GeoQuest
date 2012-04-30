/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ilyakostrikov
 */
public class Waypoint {
    public String latitude_;
    public String longtitude_;
    
    public Waypoint(String coordinates)
    {
        int leftBracket = coordinates.indexOf("(");
        int rightBracket = coordinates.indexOf(")");
        int comma = coordinates.indexOf(",");
        
        latitude_ = coordinates.substring(leftBracket+1, comma-1);
        longtitude_ = coordinates.substring(comma+4, rightBracket);
    
    }
    
    @Override
    public String toString()
    {
        return latitude_ + ", " + longtitude_;
    }
    
}
