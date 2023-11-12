package dbe.ispd.diamniodio.VoteElectronique.services;

import dbe.ispd.diamniodio.VoteElectronique.models.Electeur;
import dbe.ispd.diamniodio.VoteElectronique.repositories.ElecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ElecteurService {
    @Autowired
    private ElecteurRepository electeurRepository;

    public List<Electeur> getElecteurs(){
        return electeurRepository.findAll();
    }
    public Electeur findByVoterId(String s){
        Optional<Electeur> electeurOptional = electeurRepository.findById(s);
        return electeurOptional.orElse(null);
    }

    public void register(Electeur electeur){
        Optional<Electeur> tmp;
        tmp = electeurRepository.findById(electeur.getVoterId());
        if (!tmp.isPresent()) {
            electeurRepository.save(electeur);
        }else
            throw new RuntimeException("Cet electeur existe déjà");

    }

    public Electeur editElecteur(Electeur electeur){
        Optional<Electeur> electeurOptional = electeurRepository.findById(electeur.getVoterId());
        if (electeurOptional.isPresent()) {
            return electeurRepository.save(electeur);
        } else
            throw  new RuntimeException("Il faut renseigner l'id du electeur a modifier");
    }

    public void deleteElecteur(String id){
        electeurRepository.deleteById(id);
    }

}
