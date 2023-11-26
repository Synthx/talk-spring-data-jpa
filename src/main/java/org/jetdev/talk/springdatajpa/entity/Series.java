package org.jetdev.talk.springdatajpa.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.jetdev.talk.springdatajpa.model.SeriesType;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Series extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long year;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SeriesType type;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Kind> kinds = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "series")
    private Set<Edition> editions = new HashSet<>();
}
