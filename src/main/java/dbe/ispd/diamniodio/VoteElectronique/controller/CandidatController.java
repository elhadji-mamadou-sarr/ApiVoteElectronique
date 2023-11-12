package dbe.ispd.diamniodio.VoteElectronique.controller;

import dbe.ispd.diamniodio.VoteElectronique.models.Candidat;
import dbe.ispd.diamniodio.VoteElectronique.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @GetMapping("/candidates")
    public List<Candidat> getCandidats(){
        return candidatService.getCandidats();
    }

    @GetMapping("/candidat/{id}")
    public Candidat findByCandidat(@PathVariable String id){
        return candidatService.findByCandidat(id);
    }

    @PostMapping("/candidat")
    public Candidat register(@RequestBody Candidat candidat){
       return candidatService.registerCandidat(candidat);
    }

    @PutMapping("/candidat")
    public Candidat updateCandidat(@RequestBody Candidat candidat){
        return candidatService.editCandidat(candidat);
    }

    @DeleteMapping("/candidat/{id}")
    public void  delete(@PathVariable String id){
        candidatService.deleteCandidat(id);
    }

}
