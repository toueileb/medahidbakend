package org.sidi.repository;

import org.sidi.entities.Projet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
    @Query("From Projet p WHERE p.intitule=:searchText ORDER BY p.intitule DESC")
    Page<Projet> findAllProjets(Pageable pageable, @Param("searchText") String searchText);
}
