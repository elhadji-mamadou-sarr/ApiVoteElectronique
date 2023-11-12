package dbe.ispd.diamniodio.VoteElectronique.repositories;

import dbe.ispd.diamniodio.VoteElectronique.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoterRepository extends JpaRepository<Vote, Long> {

    @Query("SELECT v FROM Vote v WHERE v.candidat.candidatId = :candidatId")
    List<Vote> findVotesByCandidatId(@Param("candidatId") String candidatId);
}
