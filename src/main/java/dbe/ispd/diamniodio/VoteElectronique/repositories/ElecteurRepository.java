package dbe.ispd.diamniodio.VoteElectronique.repositories;

import dbe.ispd.diamniodio.VoteElectronique.models.Electeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElecteurRepository extends JpaRepository<Electeur, String> {
}
