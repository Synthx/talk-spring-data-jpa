package org.jetdev.talk.springdatajpa.repository;

import org.jetdev.talk.springdatajpa.entity.Volume;
import org.jetdev.talk.springdatajpa.view.BookCardView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VolumeRepository extends JpaRepository<Volume, UUID>, JpaSpecificationExecutor<Volume> {
    <T> T findById(UUID id, Class<T> type);

    <T> Page<T> findAllBy(Pageable pageable, Class<T> type);

    @Query("select v from Volume v join fetch v.edition e join fetch e.series s")
    Page<BookCardView> findAllCardBy(Pageable pageable);
}
