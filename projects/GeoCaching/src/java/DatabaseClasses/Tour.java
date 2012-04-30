/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseClasses;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Beatriz
 */
@Entity
@Table(name = "tour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tour.findAll", query = "SELECT t FROM Tour t"),
    @NamedQuery(name = "Tour.getLastTourId", query = "SELECT max(t.idtour) FROM Tour t"),
    @NamedQuery(name = "Tour.findByIdtour", query = "SELECT t FROM Tour t WHERE t.idtour = :idtour"),
    @NamedQuery(name = "Tour.findByName", query = "SELECT t FROM Tour t WHERE t.name = :name"),
    @NamedQuery(name = "Tour.findByDescription", query = "SELECT t FROM Tour t WHERE t.description = :description"),
    @NamedQuery(name = "Tour.findByDifficulty", query = "SELECT t FROM Tour t WHERE t.difficulty = :difficulty")})
public class Tour implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtour")
    private Integer idtour;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Size(max = 10)
    @Column(name = "difficulty")
    private String difficulty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tour")
    private Collection<Waypoint> waypointCollection;

    public Tour() {
    }

    public Tour(Integer idtour) {
        this.idtour = idtour;
    }

    public Integer getIdtour() {
        return idtour;
    }

    public void setIdtour(Integer idtour) {
        this.idtour = idtour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @XmlTransient
    public Collection<Waypoint> getWaypointCollection() {
        return waypointCollection;
    }

    public void setWaypointCollection(Collection<Waypoint> waypointCollection) {
        this.waypointCollection = waypointCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtour != null ? idtour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tour)) {
            return false;
        }
        Tour other = (Tour) object;
        if ((this.idtour == null && other.idtour != null) || (this.idtour != null && !this.idtour.equals(other.idtour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatabaseClasses.Tour[ idtour=" + idtour + " ]";
    }
    
}
