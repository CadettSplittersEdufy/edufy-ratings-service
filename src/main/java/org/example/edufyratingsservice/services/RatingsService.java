package org.example.edufyratingsservice.services;

import org.example.edufyratingsservice.entities.Rating;

import java.util.List;

public interface RatingsService {
    Rating newRating(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingsByUserId(Long userId);

    List<Rating> getRatingsByGenre(String genre);

    Rating updateRating(Rating rating);

    void deleteRating(Long id);
}
