package dbe.ispd.diamniodio.VoteElectronique.controller;

import dbe.ispd.diamniodio.VoteElectronique.models.Vote;
import dbe.ispd.diamniodio.VoteElectronique.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class VoteController {

    @Autowired
    private VoterService voterService;

    @GetMapping("/votes")
    public List<Vote> getVotes(){
        return voterService.getVotes();
    }

    @GetMapping("/votes/{candidatId}")
    public List<Vote> findVotesByCandidatId(@PathVariable String candidatId){
        return voterService.getVoteByCandidat(candidatId);
    }

    @PostMapping("/voting/cast-vote")
    public Vote voter(@RequestParam String voterId, @RequestParam String candidatId) {
        return voterService.voter(voterId, candidatId);
    }

}
