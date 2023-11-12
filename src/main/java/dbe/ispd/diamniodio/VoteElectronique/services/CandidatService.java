package dbe.ispd.diamniodio.VoteElectronique.services;

import dbe.ispd.diamniodio.VoteElectronique.models.Candidat;
import dbe.ispd.diamniodio.VoteElectronique.repositories.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    public List<Candidat> getCandidats(){
        return candidatRepository.findAll();
    }

    public Candidat registerCandidat(Candidat candidat){
       return candidatRepository.save(candidat);
    }

    public Candidat findByCandidat(String id){
        Optional<Candidat> candidatOptional = candidatRepository.findById(id);
        return candidatOptional.orElse(null);
    }

    public Candidat editCandidat(Candidat candidat){
        Optional<Candidat> candidatOptional = candidatRepository.findById(candidat.getCandidatId());
        if (candidatOptional.isPresent()) {
            return candidatRepository.save(candidat);
        } else
            throw  new RuntimeException("Renseigner l'identifiant a modifier");
    }

    public void deleteCandidat(String s){
        candidatRepository.deleteById(s);
    }

}
