package org.jetdev.talk.springdatajpa.controller;

import lombok.RequiredArgsConstructor;
import org.jetdev.talk.springdatajpa.service.VolumeService;
import org.jetdev.talk.springdatajpa.view.BookCardView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/volumes")
@RequiredArgsConstructor
public class VolumeController {
    private final VolumeService volumeService;

    @GetMapping
    public Page<BookCardView> getAll(Pageable pageable) {
        return volumeService.getAll(pageable);
    }

    @GetMapping("{id}")
    public BookCardView getById(@PathVariable UUID id) {
        return volumeService.getById(id);
    }
}
