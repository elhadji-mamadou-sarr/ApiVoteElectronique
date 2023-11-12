package dbe.ispd.diamniodio.VoteElectronique.controller;

import dbe.ispd.diamniodio.VoteElectronique.models.Electeur;
import dbe.ispd.diamniodio.VoteElectronique.services.ElecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voters")
public class ElecteurController {
    @Autowired
    private ElecteurService electeurService;

    @GetMapping
    public List<Electeur> getElecteurs(){
        return electeurService.getElecteurs();
    }

    @GetMapping("/{id}")
    public Electeur findElecteur(@PathVariable String id){
        return electeurService.findByVoterId(id);
    }

    @PostMapping("/register")
    public void registreElecteur(@RequestBody Electeur electeur){
        electeurService.register(electeur);
    }

    @PutMapping
    public Electeur editElecteur(@RequestBody Electeur electeur){
        return electeurService.editElecteur(electeur);
    }

    @DeleteMapping("/{id}")
    public void deleteElecteur(@PathVariable String id){
        electeurService.deleteElecteur(id);
    }

}
