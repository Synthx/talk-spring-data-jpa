package org.jetdev.talk.springdatajpa.view;

import org.jetdev.talk.springdatajpa.model.EditionStatus;

import java.util.Date;
import java.util.UUID;

public interface BookCardView {
    UUID getId();

    String getName();

    String getImageUrl();

    Date getPublicationDate();

    Edition getEdition();

    interface Edition {
        UUID getId();

        String getName();

        EditionStatus getStatus();

        Series getSeries();

        interface Series {
            UUID getId();

            String getName();
        }
    }
}
