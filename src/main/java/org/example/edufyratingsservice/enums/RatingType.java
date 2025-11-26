package org.example.edufyratingsservice.enums;

import java.util.Optional;

public enum RatingType {
    LIKE,
    DISLIKE;

    public static Optional<RatingType> fromString(String ratingType) {
        if (ratingType == null) {
            return Optional.empty();
        }

        try {
            return Optional.of(RatingType.valueOf(ratingType.toUpperCase()));
        } catch (IllegalArgumentException ex) {
            return Optional.empty();
        }
    }


    public String toRatingTypeString() {
        return this.toString();
    }
}
