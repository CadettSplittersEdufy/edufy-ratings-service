package org.example.edufyratingsservice.configs.entities;

import jakarta.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=25, nullable=false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length=25, nullable = false)
    private RatingType ratingType;

    @Column(length = 25, nullable = false)
    private Long userId;

    public enum RatingType {THUMBSUP, THUMBSDOWN}

    public Rating(Long userId, RatingType ratingType) {
        this.userId = userId;
        this.ratingType = ratingType;
    }

    public Rating() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RatingType getRatingType() {
        return ratingType;
    }

    public void setRatingType(RatingType ratingType) {
        this.ratingType = ratingType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", ratingType=" + ratingType +
                ", userId=" + userId +
                '}';
    }
}
