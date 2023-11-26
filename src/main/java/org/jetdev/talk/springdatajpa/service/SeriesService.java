package org.jetdev.talk.springdatajpa.service;

import lombok.RequiredArgsConstructor;
import org.jetdev.talk.springdatajpa.repository.SeriesRepository;
import org.jetdev.talk.springdatajpa.view.SeriesView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SeriesService {
    private final SeriesRepository repository;

    public Page<SeriesView> getAll(Pageable pageable) {
        return repository.findAllViewBy(pageable);
    }

    public SeriesView getById(UUID id) {
        return repository.findViewById(id);
    }
}
