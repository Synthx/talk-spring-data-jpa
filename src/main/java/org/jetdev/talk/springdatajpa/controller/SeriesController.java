package org.jetdev.talk.springdatajpa.controller;

import lombok.RequiredArgsConstructor;
import org.jetdev.talk.springdatajpa.service.SeriesService;
import org.jetdev.talk.springdatajpa.view.SeriesView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/series")
@RequiredArgsConstructor
public class SeriesController {
    private final SeriesService seriesService;

    @GetMapping
    public Page<SeriesView> getAll(Pageable pageable) {
        return seriesService.getAll(pageable);
    }

    @GetMapping("{id}")
    public SeriesView getById(@PathVariable UUID id) {
        return seriesService.getById(id);
    }
}
