package org.jetdev.talk.springdatajpa.view;

import java.util.List;
import java.util.UUID;

public interface SeriesView {
    UUID getId();

    String getName();

    List<Author> getAuthors();

    interface Author {
        UUID getId();

        String getName();
    }
}
