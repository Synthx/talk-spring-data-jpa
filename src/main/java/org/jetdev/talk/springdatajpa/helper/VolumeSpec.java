package org.jetdev.talk.springdatajpa.helper;

import org.jetdev.talk.springdatajpa.entity.Volume;
import org.jetdev.talk.springdatajpa.entity.Volume_;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;

public class VolumeSpec {
    public static Specification<Volume> numberEqual(Long number) {
        return (root, query, builder) -> {
            // avoid fetching in count query
            if (query.getResultType() != Long.class) {
                root.fetch(Volume_.edition);
            }

            return builder.equal(root.get(Volume_.number), number);
        };
    }

    public static Example<Volume> numberEqualExample(Long number) {
        Volume volume = new Volume();
        volume.setNumber(number);

        return Example.of(volume);
    }
}
