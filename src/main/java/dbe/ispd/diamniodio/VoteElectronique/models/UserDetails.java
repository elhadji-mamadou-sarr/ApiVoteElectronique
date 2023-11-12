package dbe.ispd.diamniodio.VoteElectronique.models;

import java.util.ArrayList;
import java.util.List;

public class UserDetails {

    private  String voteId;
    private String nom;

    private String nationaliteId;

    private String token;
    private List<Role> roles;

    private  List<String> role2;

    public UserDetails(){

    }

    public UserDetails(Autorisation autorisation, String message){
        this.voteId = autorisation.getElecteur().getVoterId();
        this.nom= autorisation.getElecteur().getName();
        this.nationaliteId = autorisation.getElecteur().getNationalId();
        this.token = autorisation.getIdToken();
        this.roles=autorisation.getElecteur().getRoles();
        role2= new ArrayList<>();
        for (Role r: roles) {
            role2.add(r.getCode());
        }
    }

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    public String getNationaliteId() {
        return nationaliteId;
    }

    public void setNationaliteId(String nationaliteId) {
        this.nationaliteId = nationaliteId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setRole2(List<String> role2) {
        this.role2 = role2;
    }

    public List<String> getRole2() {
        return role2;
    }
}
