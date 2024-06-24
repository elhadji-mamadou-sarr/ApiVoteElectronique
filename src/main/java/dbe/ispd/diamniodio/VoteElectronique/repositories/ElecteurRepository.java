package dbe.ispd.diamniodio.VoteElectronique.repositories;

import dbe.ispd.diamniodio.VoteElectronique.models.Electeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ElecteurRepository extends JpaRepository<Electeur, String> {
    @Query("SELECT a FROM Electeur a where a.voterId=:voterId")
    public Electeur findByLogin(String voterId);
}

