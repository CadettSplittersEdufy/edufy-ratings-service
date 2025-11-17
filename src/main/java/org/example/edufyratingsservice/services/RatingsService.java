package org.example.edufyratingsservice.services;

import org.example.edufyratingsservice.dtos.RatingDTO;
import org.example.edufyratingsservice.enums.MediaType;

import java.util.List;

public interface RatingsService {
    RatingDTO newRating(RatingDTO ratingDTO);

    List<RatingDTO> getAllRatings();

    List<RatingDTO> getUsersRatings(Long userId);

    List<RatingDTO> getUsersRatingsByMediaType(Long userId, MediaType mediaType);

    List<RatingDTO> getLikesByMediaType(MediaType mediaType, Long mediaId);

    RatingDTO updateRating(RatingDTO rating);

    void deleteRating(Long ratingId);
}
