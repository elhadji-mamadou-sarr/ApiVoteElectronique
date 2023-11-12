package dbe.ispd.diamniodio.VoteElectronique.services;

import dbe.ispd.diamniodio.VoteElectronique.models.Candidat;
import dbe.ispd.diamniodio.VoteElectronique.models.Electeur;
import dbe.ispd.diamniodio.VoteElectronique.models.Vote;
import dbe.ispd.diamniodio.VoteElectronique.repositories.CandidatRepository;
import dbe.ispd.diamniodio.VoteElectronique.repositories.ElecteurRepository;
import dbe.ispd.diamniodio.VoteElectronique.repositories.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterService{

    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private CandidatRepository candidatRepository;
    @Autowired
    private ElecteurRepository electeurRepository;

    public List<Vote> getVotes(){
        return voterRepository.findAll();
    }

    public Vote getVoteById(Long aLong){
        Optional<Vote> voteOptional = voterRepository.findById(aLong);
        return voteOptional.orElse(null);
    }

    public List<Vote> getVoteByCandidat(String candidatId){
        return  voterRepository.findVotesByCandidatId(candidatId);
    }

    public Vote voter(String voterId, String candidatId){
        Vote vote = null;
        Optional<Electeur> electeur =electeurRepository.findById(voterId);
        Optional<Candidat> candidat = candidatRepository.findById(candidatId);
        if (candidat.isPresent()  && electeur.isPresent()) {
        Electeur newElecteur1 = electeur.orElse(null);
        Candidat newCandidat1 = candidat.orElse(null);
            vote = new Vote(newElecteur1, newCandidat1);
            voterRepository.save(vote);
        }
        return vote;
    }

}
