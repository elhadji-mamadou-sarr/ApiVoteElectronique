package dbe.ispd.diamniodio.VoteElectronique.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Candidat {

    @Id
    private String candidatId;
    private String name;
    private String party;

    @OneToMany
    private List<Vote> votes;

    public Candidat(String candidatId, String name, String party) {
        this.candidatId = candidatId;
        this.name = name;
        this.party = party;
    }

    public Candidat() {
    }

    public String getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(String candidatId) {
        this.candidatId = candidatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

}
