package dbe.ispd.diamniodio.VoteElectronique.models;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Electeur electeur;

    @ManyToOne
    private Candidat candidat;

    public Vote(Electeur electeur, Candidat candidat) {
        this.electeur = electeur;
        this.candidat = candidat;
    }
    public Vote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Electeur getElecteur() {
        return electeur;
    }

    public void setElecteur(Electeur electeur) {
        this.electeur = electeur;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

}
