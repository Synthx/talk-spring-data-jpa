package org.jetdev.talk.springdatajpa.view;

import org.jetdev.talk.springdatajpa.model.EditionStatus;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface EditionView {
    UUID getId();

    String getName();

    EditionStatus getStatus();

    List<Volume> getVolumes();

    interface Volume {
        UUID getId();

        String getImageUrl();

        Date getPublicationDate();
    }
}
