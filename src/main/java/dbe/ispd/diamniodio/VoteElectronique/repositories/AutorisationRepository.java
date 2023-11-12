package dbe.ispd.diamniodio.VoteElectronique.repositories;

import dbe.ispd.diamniodio.VoteElectronique.models.Autorisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorisationRepository extends JpaRepository<Autorisation, String> {
}
