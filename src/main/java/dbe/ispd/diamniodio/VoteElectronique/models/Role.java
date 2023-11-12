package dbe.ispd.diamniodio.VoteElectronique.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity(name = "roles")
public class Role {

    @Id
    private String code;
    @Column(nullable = false, unique = true)
    private String nom;
    private String description;

    @ManyToMany(mappedBy = "roles")
    private List<Electeur> apprenants;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Role(){

    }

    public Role(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }
}
