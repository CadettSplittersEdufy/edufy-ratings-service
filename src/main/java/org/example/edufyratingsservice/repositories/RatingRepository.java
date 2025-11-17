package org.example.edufyratingsservice.repositories;

import org.example.edufyratingsservice.entities.Rating;
import org.example.edufyratingsservice.enums.MediaType;
import org.example.edufyratingsservice.enums.RatingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUserId(Long userId);
    List<Rating> findByUserIdAndMediaType(Long userId, MediaType mediaType);
    List<Rating> findByMediaTypeAndMediaIdAndRatingType(MediaType mediaType, Long mediaId, RatingType ratingType);
    List<Rating> findRatingsByUserIdAndRatingType(Long userId, RatingType ratingType);
}
