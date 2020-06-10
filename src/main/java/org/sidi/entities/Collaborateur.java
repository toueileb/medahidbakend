package org.sidi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Collaborateur implements Serializable {
    private static final long serialVersionUID = 8316342209192258741L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeCollab;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "collaborateur")
    private List<Competence> competences;

    @ManyToOne
    private Tache tache;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeCollab() {
        return codeCollab;
    }

    public void setCodeCollab(String codeCollab) {
        this.codeCollab = codeCollab;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }
}
