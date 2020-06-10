package org.sidi.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Competence implements Serializable {

    private static final long serialVersionUID = 6839397287177903057L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;

    @ManyToOne(cascade = CascadeType.ALL)
    private Collaborateur collaborateur;

    @ManyToOne
    private Tache tache;

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

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }
}
