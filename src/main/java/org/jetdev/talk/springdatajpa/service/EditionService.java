package org.jetdev.talk.springdatajpa.service;

import lombok.RequiredArgsConstructor;
import org.jetdev.talk.springdatajpa.repository.EditionRepository;
import org.jetdev.talk.springdatajpa.view.EditionView;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditionService {
    private final EditionRepository repository;

    public EditionView getById(UUID id) {
        return repository.findById(id, EditionView.class);
    }
}
