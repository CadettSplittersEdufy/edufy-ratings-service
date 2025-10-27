package org.example.edufyratingsservice.controllers;

import org.example.edufyratingsservice.entities.Rating;
import org.example.edufyratingsservice.services.RatingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingsController {

    private RatingsServiceImpl ratingsService;

    @Autowired
    public RatingsController(RatingsServiceImpl ratingsService) {
        this.ratingsService = ratingsService;
    }

    @GetMapping("/test")
    public String test() {
        return "This is the ratings controller test";
    }

    @PostMapping("/newrating")
    public Rating addRating(@RequestBody Rating rating) {
        return ratingsService.newRating(rating);
    }

    @GetMapping("/ratings")
    public List<Rating> getAllRatings() {
        return ratingsService.getAllRatings();
    }

    @GetMapping("/ratings/{userId}")
    public List<Rating> getAllUsersRatings(@PathVariable Long userId) {
        return ratingsService.getRatingsByUserId(userId);
    }

    @GetMapping("/ratingby/{genre}")
    public List<Rating> getRatingsByGenre(@PathVariable String genre) {
        return ratingsService.getRatingsByGenre(genre);
    }

    @PutMapping("/changeRating")
    public Rating updateRating(@RequestBody Rating rating) {
        return ratingsService.updateRating(rating);
    }

    @DeleteMapping("/deleterating")
    public void deleteRating(@RequestBody Rating rating) {
        ratingsService.deleteRating(rating.getId());
    }

}

