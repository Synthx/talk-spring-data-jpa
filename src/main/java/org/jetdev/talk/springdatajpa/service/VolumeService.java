package org.jetdev.talk.springdatajpa.service;

import lombok.RequiredArgsConstructor;
import org.jetdev.talk.springdatajpa.repository.VolumeRepository;
import org.jetdev.talk.springdatajpa.view.BookCardView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VolumeService {
    private final VolumeRepository repository;

    public Page<BookCardView> getAll(Pageable pageable) {
        return repository.findAllCardBy(pageable);
    }

    public BookCardView getById(UUID id) {
        return repository.findById(id, BookCardView.class);
    }

    @Transactional
    public void update() {
        // do update ...
    }
}
