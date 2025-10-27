package org.example.edufyratingsservice.repositories;

import org.example.edufyratingsservice.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByGenre(String genre);
    List<Rating> findByUserId(Long userId);
}
