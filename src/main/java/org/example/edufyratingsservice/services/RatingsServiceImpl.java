package org.example.edufyratingsservice.services;

import org.example.edufyratingsservice.entities.Rating;
import org.example.edufyratingsservice.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class RatingsServiceImpl implements RatingsService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingsServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating newRating(Rating rating) {
        Rating newRating = new Rating();
        newRating.setRatingType(rating.getRatingType());
        newRating.setUserId(rating.getUserId());
        return ratingRepository.save(newRating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }


    @Override
    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByGenre(String genre) {
        return ratingRepository.findByGenre(genre);
    }

    @Override
    public Rating updateRating(Rating rating) {
        Optional<Rating> ratingToUpdate = ratingRepository.findById(rating.getId());
        if (ratingToUpdate.isPresent()) {
            ratingToUpdate.get().setRatingType(rating.getRatingType());
            ratingToUpdate.get().setUserId(rating.getUserId());
            ratingToUpdate.get().setMediaType(rating.getMediaType());
            return ratingRepository.save(rating);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteRating(Long id) {
        Optional<Rating> ratingToDelete = ratingRepository.findById(id);
        if (ratingToDelete.isPresent()) {
            ratingRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}
