package dbe.ispd.diamniodio.VoteElectronique.models;

import dbe.ispd.diamniodio.VoteElectronique.VoteElectroniqueApplication;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Electeur {
    @Id
    private String voterId;
    private String name;
    private String nationalId;
    private Date dateOfBirth;
    private String password;

    @OneToOne(mappedBy = "electeur")
    private Vote vote;

    public Electeur(String name, String nationalId, Date dateOfBirth, String voterId, String password) {
        this.name = name;
        this.nationalId = nationalId;
        this.dateOfBirth = dateOfBirth;
        this.voterId = voterId;
        this.password = password;
    }

    public Electeur() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
