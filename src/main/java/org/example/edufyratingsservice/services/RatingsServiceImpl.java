package org.example.edufyratingsservice.services;

import org.example.edufyratingsservice.dtos.RatingDTO;
import org.example.edufyratingsservice.entities.Rating;
import org.example.edufyratingsservice.enums.MediaType;
import org.example.edufyratingsservice.enums.RatingType;
import org.example.edufyratingsservice.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
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
    public RatingDTO newRating(RatingDTO ratingDTO) {
        if (ratingDTO.getUserId() == null
                || ratingDTO.getMediaId() == null
                || ratingDTO.getMediaType() == null
                || ratingDTO.getRatingType() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "All fields are required");
        }

        Rating newRating = new Rating();
        newRating.setRatingType(ratingDTO.getRatingType());
        newRating.setUserId(ratingDTO.getUserId());
        newRating.setMediaType(ratingDTO.getMediaType());
        newRating.setMediaId(ratingDTO.getMediaId());
        ratingRepository.save(newRating);
        return convertToDTO(newRating);
    }

    @Override
    public List<RatingDTO> getAllRatings() {
        List<Rating> ratings = ratingRepository.findAll();
        List<RatingDTO> ratingDTOs = convertToDTOList(ratings);
        return ratingDTOs;
    }

    @Override
    public List<RatingDTO> getUsersRatings(Long userId) {
        List<Rating> ratings = ratingRepository.findByUserId(userId);
        return convertToDTOList(ratings);
    }

    public List<RatingDTO> getUsersLikes(Long userId){
        List<Rating> ratings = ratingRepository.findRatingsByUserIdAndRatingType(userId, RatingType.LIKE);
        return convertToDTOList(ratings);
    }

    public List<RatingDTO> getUsersDislikes(Long userId){
        List<Rating> ratings = ratingRepository.findRatingsByUserIdAndRatingType(userId, RatingType.DISLIKE);
        return convertToDTOList(ratings);
    }

    @Override
    public List<RatingDTO> getUsersRatingsByMediaType(Long userId, MediaType mediaType){
        List<Rating> ratings = ratingRepository.findByUserIdAndMediaType(userId, mediaType);
        return convertToDTOList(ratings);
    }

    @Override
    public List<RatingDTO> getLikesByMediaType(MediaType mediaType, Long mediaId){
        List<Rating> ratings = ratingRepository.findByMediaTypeAndMediaIdAndRatingType(mediaType, mediaId, RatingType.LIKE);
        return convertToDTOList(ratings);
    }

    public List<RatingDTO> getDislikesByMediaType(MediaType mediaType, Long mediaId){
        List<Rating> ratings = ratingRepository.findByMediaTypeAndMediaIdAndRatingType(mediaType, mediaId, RatingType.DISLIKE);
        return convertToDTOList(ratings);
    }

    @Override
    public RatingDTO updateRating(RatingDTO rating) {
        if(rating.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id is required");
        }

        Optional<Rating> ratingToUpdate = ratingRepository.findById(rating.getId());
        if (ratingToUpdate.isPresent()) {
            Rating updatedRating = ratingToUpdate.get();
            if(rating.getRatingType() != null) {
                updatedRating.setRatingType(rating.getRatingType());
            }
            if(rating.getMediaId() != null) {
                updatedRating.setMediaId(rating.getMediaId());
            }
            if(rating.getMediaType() != null) {
                updatedRating.setMediaType(rating.getMediaType());
            }
            if(rating.getUserId() != null) {
                updatedRating.setUserId(rating.getUserId());
            }
            ratingRepository.save(updatedRating);
            return convertToDTO(updatedRating);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public RatingDTO convertToDTO(Rating rating) {
        RatingDTO dto = new RatingDTO();
        dto.setId(rating.getId());
        dto.setMediaId(rating.getMediaId());
        dto.setRatingType(rating.getRatingType());
        dto.setUserId(rating.getUserId());
        dto.setMediaType(rating.getMediaType());
        return dto;
    }

    public List<RatingDTO> convertToDTOList(List<Rating> ratings) {
        if (ratings == null || ratings.isEmpty()) {
            return Collections.emptyList();
        }

        return ratings.stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public void deleteRating(Long ratingId) {
        Optional<Rating> ratingToDelete = ratingRepository.findById(ratingId);
        if (ratingToDelete.isPresent()) {
            ratingRepository.deleteById(ratingId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
