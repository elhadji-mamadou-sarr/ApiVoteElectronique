package dbe.ispd.diamniodio.VoteElectronique.repositories;

import dbe.ispd.diamniodio.VoteElectronique.models.Candidat;
import dbe.ispd.diamniodio.VoteElectronique.models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface CandidatRepository extends JpaRepository<Candidat, String> {


}
