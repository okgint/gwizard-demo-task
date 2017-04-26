package org.ogin.util;

import java.util.Optional;

/**
 * Created by Oktavianus on 4/26/2017.
 */
public class OptionalTask {
    private Optional<String> contains;

    public OptionalTask(String value) {
        this.contains = Optional.of(value);
    }

    public Optional<String> getContains() {
        return contains;
    }
}
