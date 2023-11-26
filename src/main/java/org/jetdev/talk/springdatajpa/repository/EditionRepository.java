package org.jetdev.talk.springdatajpa.repository;

import org.jetdev.talk.springdatajpa.entity.Edition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EditionRepository extends JpaRepository<Edition, UUID> {
    <T> T findById(UUID id, Class<T> type);
}
