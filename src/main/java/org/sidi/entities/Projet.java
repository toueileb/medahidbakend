package org.sidi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Projet implements Serializable {

    private static final long serialVersionUID = 268194052501461412L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;
    private long volumeHoraire;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateFin;

    @JsonIgnore
    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    private List<Tache> taches;

    @PrePersist
    public void onCreate(){
        this.dateDebut = new Date();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public long getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(long volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }
}
