/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Beatriz
 */
@Embeddable
public class WaypointPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idwaypoint")
    private int idwaypoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_idtour")
    private int fkIdtour;

    public WaypointPK() {
    }

    public WaypointPK(int idwaypoint, int fkIdtour) {
        this.idwaypoint = idwaypoint;
        this.fkIdtour = fkIdtour;
    }

    public int getIdwaypoint() {
        return idwaypoint;
    }

    public void setIdwaypoint(int idwaypoint) {
        this.idwaypoint = idwaypoint;
    }

    public int getFkIdtour() {
        return fkIdtour;
    }

    public void setFkIdtour(int fkIdtour) {
        this.fkIdtour = fkIdtour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idwaypoint;
        hash += (int) fkIdtour;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WaypointPK)) {
            return false;
        }
        WaypointPK other = (WaypointPK) object;
        if (this.idwaypoint != other.idwaypoint) {
            return false;
        }
        if (this.fkIdtour != other.fkIdtour) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatabaseClasses.WaypointPK[ idwaypoint=" + idwaypoint + ", fkIdtour=" + fkIdtour + " ]";
    }
    
}
