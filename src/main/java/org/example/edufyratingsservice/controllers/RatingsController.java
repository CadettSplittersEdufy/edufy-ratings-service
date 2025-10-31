package org.example.edufyratingsservice.controllers;

import jakarta.validation.Valid;
import org.example.edufyratingsservice.dtos.RatingDTO;
import org.example.edufyratingsservice.enums.MediaType;
import org.example.edufyratingsservice.services.RatingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    private final RatingsServiceImpl ratingsService;

    @Autowired
    public RatingsController(RatingsServiceImpl ratingsService) {
        this.ratingsService = ratingsService;
    }

    @GetMapping("/test")
    public String test() {
        return "This is the ratings controller test";
    }

    @PostMapping("/add")
    public ResponseEntity<RatingDTO> addRating(
            @Valid @RequestBody RatingDTO ratingDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ratingsService.newRating(ratingDTO));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<RatingDTO>> getAllRatings() {
        List<RatingDTO> ratings = ratingsService.getAllRatings();
        if (ratings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/getbyuser/{userId}")
    public ResponseEntity<List<RatingDTO>> getAllUsersRatings(@PathVariable Long userId) {
        List<RatingDTO> ratings = ratingsService.getUsersRatings(userId);
        if (ratings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/ratingbyuserandmediatype/{userId}/{mediaType}")
    public ResponseEntity<List<RatingDTO>> getRatingsByGenre(@PathVariable Long userId, @PathVariable MediaType mediaType) {
        List<RatingDTO> ratings = ratingsService.getUsersRatingsByMediaType(userId, mediaType);
        if (ratings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/ratingsbymedia/{mediaType}/{mediaId}")
    public ResponseEntity<List<RatingDTO>> getRatingsByMedia(@PathVariable MediaType mediaType, @PathVariable Long mediaId) {
        List<RatingDTO> ratings = ratingsService.getRatingsByMediaType(mediaType, mediaId);
        if (ratings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ratings);
    }

    @PutMapping("/changeRating")
    public ResponseEntity<RatingDTO> updateRating(@RequestBody RatingDTO rating) {

        return ResponseEntity.ok(ratingsService.updateRating(rating));
    }

    @DeleteMapping("/deleterating/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable Long id) {
        ratingsService.deleteRating(id);
        return ResponseEntity.ok("Rating with id " + id + " was deleted.");
    }

}

