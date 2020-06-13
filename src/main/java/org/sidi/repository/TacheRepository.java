package org.sidi.repository;

import org.sidi.entities.Collaborateur;
import org.sidi.entities.Tache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
    @Query("From Tache t WHERE t.intitule=:searchText ORDER BY t.intitule DESC")
    Page<Tache> findAllTaches(Pageable pageable, @Param("searchText") String searchText);
}
