package dbe.ispd.diamniodio.VoteElectronique.controller;

import dbe.ispd.diamniodio.VoteElectronique.models.Autorisation;
import dbe.ispd.diamniodio.VoteElectronique.models.UserDetails;
import dbe.ispd.diamniodio.VoteElectronique.models.UserLoginForm;
import dbe.ispd.diamniodio.VoteElectronique.services.ElecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private ElecteurService electeurService;

    @PostMapping
    protected ResponseEntity login(@RequestBody UserLoginForm userLoginForm)  {
        System.out.println("authentification de "+userLoginForm);
        System.out.println("----------------------------------------"+userLoginForm.getVoterId());
        String login = userLoginForm.getVoterId();

        String password = userLoginForm.getPassword();
        Autorisation res = electeurService.login(login, password);

        if (res == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Indentifiant incorrecte");
        }
        return ResponseEntity.ok(new UserDetails(res, "Connecté avec succès"));
    }
}
