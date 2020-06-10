package org.sidi.repository;

import org.sidi.entities.Competence;
import org.sidi.entities.Projet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    @Query("From Competence com WHERE com.intitule=:searchText ORDER BY com.intitule DESC")
    Page<Competence> findAllCompetences(Pageable pageable, @Param("searchText") String searchText);
}
