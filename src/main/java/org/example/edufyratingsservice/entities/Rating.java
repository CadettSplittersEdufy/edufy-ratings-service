package org.example.edufyratingsservice.entities;

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

    @Column(length = 50, nullable = false)
    private String mediaType;

    @Column(length = 25, nullable = false)
    private String genre;

    public enum RatingType {THUMBSUP, THUMBSDOWN}

    public Rating(Long userId, RatingType ratingType, String mediaType, String genre) {
        this.userId = userId;
        this.ratingType = ratingType;
        this.mediaType = mediaType;
        this.genre = genre;
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

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", ratingType=" + ratingType +
                ", userId=" + userId +
                ", mediaType='" + mediaType +
                ", genre='" + genre +
                '}';
    }
}
