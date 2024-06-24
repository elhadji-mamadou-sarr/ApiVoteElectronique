package dbe.ispd.diamniodio.VoteElectronique.services;

import dbe.ispd.diamniodio.VoteElectronique.config.security.HashPassword;
import dbe.ispd.diamniodio.VoteElectronique.models.Autorisation;
import dbe.ispd.diamniodio.VoteElectronique.models.Electeur;
import dbe.ispd.diamniodio.VoteElectronique.repositories.AutorisationRepository;
import dbe.ispd.diamniodio.VoteElectronique.repositories.ElecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ElecteurService {
    @Autowired
    private ElecteurRepository electeurRepository;

    @Autowired
    private AutorisationRepository autorisationRepository;


    public Autorisation login(String login, String password){
        Electeur electeur = electeurRepository.findByLogin(login);

        //String pwd = HashPassword.gen
        //
        //
        // SHA512(password);
        if (electeur.getPassword().equals(password)) {
            Autorisation resultat = new Autorisation();
            resultat.setIdToken(genToken());
            resultat.setElecteur(electeur);
            Date d = new Date();
            resultat.setDateCreation(d);
            Date expire = new Date(d.getTime()+(30*60*1000));
            resultat.setDerniereUtilisation(expire);
            autorisationRepository.save(resultat);
            return resultat;
        }
        return null;
    }

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
           /* String motDePasseEncode = passwordEncoder.encode(electeur.getPassword());
            electeur.setPassword(motDePasseEncode);*/
            electeurRepository.save(electeur);
        }else
            throw new RuntimeException("Cet electeur existe déjà");

    }

    public Electeur findByLogin(String s){
        Electeur electeur = electeurRepository.findByLogin(s);
        return electeur;
    }

    public Electeur editElecteur(Electeur electeur){
        Optional<Electeur> electeurOptional = electeurRepository.findById(electeur.getVoterId());
        if (electeurOptional.isPresent()) {
           /* String motDePasseEncode = passwordEncoder.encode(electeur.getPassword());
            electeur.setPassword(motDePasseEncode);*/
            return electeurRepository.save(electeur);
        } else
            throw  new RuntimeException("Il faut renseigner l'id du electeur a modifier");
    }

    public void deleteElecteur(String id){
        electeurRepository.deleteById(id);
    }

    public  String genToken(){
        String dico = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        String token = "";
        int longueurToken =120;
        Autorisation autorisation = null;
        do {
            for (int i = 0; i < longueurToken; i++){
                int indeiceAlea = (int) (Math.random()*dico.length());
                token+=dico.charAt(indeiceAlea);
                autorisation=autorisationRepository.findById(token).orElse(null);
            }
        }while (autorisation != null);
        return token;
    }


}
