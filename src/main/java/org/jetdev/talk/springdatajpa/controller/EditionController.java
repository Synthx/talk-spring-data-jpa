package org.jetdev.talk.springdatajpa.controller;

import lombok.RequiredArgsConstructor;
import org.jetdev.talk.springdatajpa.service.EditionService;
import org.jetdev.talk.springdatajpa.view.EditionView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/editions")
@RequiredArgsConstructor
public class EditionController {
    private final EditionService editionService;

    @GetMapping("{id}")
    public EditionView getById(@PathVariable UUID id) {
        return editionService.getById(id);
    }
}
