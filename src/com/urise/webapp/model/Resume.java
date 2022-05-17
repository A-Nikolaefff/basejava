package com.urise.webapp.model;

import java.util.Objects;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private String uuid;

    public Resume(String uuid) {
        this.uuid = Objects.requireNonNull(uuid, "uuid cannot be null)");
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }
}
