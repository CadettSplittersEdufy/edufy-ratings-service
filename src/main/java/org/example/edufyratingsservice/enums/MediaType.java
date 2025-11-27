package org.example.edufyratingsservice.enums;

import java.util.Optional;

public enum MediaType {
    VIDEO, POD, MUSIC;

    public static Optional<MediaType> fromString(String mediaType) {
        if (mediaType == null) {
            return Optional.empty();
        }

        try {
            return Optional.of(MediaType.valueOf(mediaType.toUpperCase()));
        } catch (IllegalArgumentException ex) {
            return Optional.empty();
        }
    }


    public String toMediaTypeString() {
        return this.toString();
    }
}
