package org.example.edufyratingsservice.controllers;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.example.edufyratingsservice.dtos.RatingDTO;
import org.example.edufyratingsservice.enums.MediaType;
import org.example.edufyratingsservice.services.RatingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@PreAuthorize("hasAnyRole('edufy_USER','edufy_ADMIN')")
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
        List<RatingDTO> ratings = ratingsService.getAllRatings()
                ;
        if (ratings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/getlikesbyuser/{userId}")
    public ResponseEntity<List<RatingDTO>> getUsersLikesRatings(@PathVariable Long userId) {
        List<RatingDTO> ratings = ratingsService.getUsersLikes(userId);
        if (ratings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/getdislikesbyuser/{userId}")
    public ResponseEntity<List<RatingDTO>> getUsersDislikesRatings(@PathVariable Long userId) {
        List<RatingDTO> ratings = ratingsService.getUsersDislikes(userId);
        if (ratings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/getbyuserandmediatype/{userId}/{mediaType}")
    public ResponseEntity<List<RatingDTO>> getRatingsByGenre(@PathVariable Long userId, @PathVariable MediaType mediaType) {
        List<RatingDTO> ratings = ratingsService.getUsersRatingsByMediaType(userId, mediaType);
        if (ratings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ratings);
    }

    @PermitAll
    @GetMapping("/getlikesbymedia/{mediaType}/{mediaId}")
    public ResponseEntity<List<RatingDTO>> getLikesByMedia(@PathVariable MediaType mediaType, @PathVariable Long mediaId) {
        List<RatingDTO> ratings = ratingsService.getLikesByMediaType(mediaType, mediaId);
        if (ratings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ratings);
    }

    @PermitAll
    @GetMapping("/getdislikesbymedia/{mediaType}/{mediaId}")
    public ResponseEntity<List<RatingDTO>> getDislikesByMedia(@PathVariable MediaType mediaType, @PathVariable Long mediaId) {
        List<RatingDTO> ratings = ratingsService.getDislikesByMediaType(mediaType, mediaId);
        if (ratings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ratings);
    }

    @PutMapping("/changerating")
    public ResponseEntity<RatingDTO> updateRating(@RequestBody RatingDTO rating) {

        return ResponseEntity.ok(ratingsService.updateRating(rating));
    }

    @DeleteMapping("/deleterating/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable Long id) {
        ratingsService.deleteRating(id);
        return ResponseEntity.ok("Rating with id " + id + " was deleted.");
    }

}

