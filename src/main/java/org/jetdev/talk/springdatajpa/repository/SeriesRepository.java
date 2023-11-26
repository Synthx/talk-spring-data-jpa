package org.jetdev.talk.springdatajpa.repository;

import org.jetdev.talk.springdatajpa.entity.Series;
import org.jetdev.talk.springdatajpa.view.SeriesView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SeriesRepository extends JpaRepository<Series, UUID> {
    <T> T findById(UUID id, Class<T> type);

    @Query("select s from Series s join fetch s.authors a where s.id = ?1")
    SeriesView findViewById(UUID id);

    @Query("select s from Series s join fetch s.authors a")
    Page<SeriesView> findAllViewBy(Pageable pageable);
}
