package org.sidi.repository;

import org.sidi.entities.Collaborateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Long> {
    @Query("From Collaborateur c WHERE c.nom=:searchText ORDER BY c.nom DESC")
    Page<Collaborateur> findAllCollaborateurs(Pageable pageable, @Param("searchText") String searchText);
}
