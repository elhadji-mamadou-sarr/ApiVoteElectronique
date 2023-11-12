package dbe.ispd.diamniodio.VoteElectronique.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Autorisation implements Serializable {

    @Id
    @Column(nullable = false)
    private  String IdToken;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date derniereUtilisation;

    private String message;
    @ManyToOne
    @JoinColumn(name = "voterId", nullable = false)
    private  Electeur electeur;

    public Autorisation(){

    }

    public Autorisation(String idToken, Date dateCreation, Date derniereUtilisation, String message, Electeur electeur) {
        IdToken = idToken;
        this.dateCreation = dateCreation;
        this.derniereUtilisation = derniereUtilisation;
        this.message = message;
        this.electeur = electeur;
    }
    public Autorisation(String idToken, String message, Electeur electeur) {
        IdToken = idToken;
        this.message = message;
        this.electeur = electeur;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDerniereUtilisation() {
        return derniereUtilisation;
    }

    public void setDerniereUtilisation(Date derniereUtilisation) {
        this.derniereUtilisation = derniereUtilisation;
    }

    public void setIdToken(String idToken) {
        IdToken = idToken;
    }

    public String getIdToken() {
        return IdToken;
    }

    public void setElecteur(Electeur electeur) {
        this.electeur = electeur;
    }

    public Electeur getElecteur() {
        return electeur;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
