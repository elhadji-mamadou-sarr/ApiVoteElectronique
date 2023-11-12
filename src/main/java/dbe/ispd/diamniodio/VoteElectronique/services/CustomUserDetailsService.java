package dbe.ispd.diamniodio.VoteElectronique.services;
/*
import dbe.ispd.diamniodio.VoteElectronique.models.Electeur;
import dbe.ispd.diamniodio.VoteElectronique.repositories.ElecteurRepository;
import dbe.ispd.diamniodio.VoteElectronique.repositories.ElecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service*/
public class CustomUserDetailsService /*implements UserDetailsService*/ {
/*
    private final ElecteurRepository electeurRepository;

    @Autowired
    public CustomUserDetailsService(ElecteurRepository electeurRepository) {
        this.electeurRepository = electeurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String finalUsername = username;
        Electeur electeur = electeurRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Electeur non trouvé avec le voterId: " + username));
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(electeur.getPassword())
                .roles("USER")
                .build();
    }*/

}
