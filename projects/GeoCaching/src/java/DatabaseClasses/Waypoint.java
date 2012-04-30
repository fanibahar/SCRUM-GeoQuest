/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseClasses;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Beatriz
 */
@Entity
@Table(name = "waypoint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Waypoint.findAll", query = "SELECT w FROM Waypoint w"),
    @NamedQuery(name = "Waypoint.getLastWaypointId", query = "SELECT max(w.waypointPK.idwaypoint) FROM Waypoint w"),
    @NamedQuery(name = "Waypoint.findByIdwaypoint", query = "SELECT w FROM Waypoint w WHERE w.waypointPK.idwaypoint = :idwaypoint"),
    @NamedQuery(name = "Waypoint.findByName", query = "SELECT w FROM Waypoint w WHERE w.name = :name"),
    @NamedQuery(name = "Waypoint.findByLongitude", query = "SELECT w FROM Waypoint w WHERE w.longitude = :longitude"),
    @NamedQuery(name = "Waypoint.findByLatitude", query = "SELECT w FROM Waypoint w WHERE w.latitude = :latitude"),
    @NamedQuery(name = "Waypoint.findByFinal1", query = "SELECT w FROM Waypoint w WHERE w.final1 = :final1"),
    @NamedQuery(name = "Waypoint.findByOrderPosition", query = "SELECT w FROM Waypoint w WHERE w.orderPosition = :orderPosition"),
    @NamedQuery(name = "Waypoint.findByFkIdtour", query = "SELECT w FROM Waypoint w WHERE w.waypointPK.fkIdtour = :fkIdtour")})
public class Waypoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WaypointPK waypointPK;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 30)
    @Column(name = "longitude")
    private String longitude;
    @Size(max = 30)
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "final")
    private Boolean final1;
    @Column(name = "orderPosition")
    private Integer orderPosition;
    @JoinColumn(name = "fk_idtour", referencedColumnName = "idtour", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tour tour;

    public Waypoint() {
    }

    public Waypoint(WaypointPK waypointPK) {
        this.waypointPK = waypointPK;
    }

    public Waypoint(int idwaypoint, int fkIdtour) {
        this.waypointPK = new WaypointPK(idwaypoint, fkIdtour);
    }

    public WaypointPK getWaypointPK() {
        return waypointPK;
    }

    public void setWaypointPK(WaypointPK waypointPK) {
        this.waypointPK = waypointPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Boolean getFinal1() {
        return final1;
    }

    public void setFinal1(Boolean final1) {
        this.final1 = final1;
    }

    public Integer getOrderPosition() {
        return orderPosition;
    }

    public void setOrderPosition(Integer orderPosition) {
        this.orderPosition = orderPosition;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (waypointPK != null ? waypointPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Waypoint)) {
            return false;
        }
        Waypoint other = (Waypoint) object;
        if ((this.waypointPK == null && other.waypointPK != null) || (this.waypointPK != null && !this.waypointPK.equals(other.waypointPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatabaseClasses.Waypoint[ waypointPK=" + waypointPK + " ]";
    }
    
}
