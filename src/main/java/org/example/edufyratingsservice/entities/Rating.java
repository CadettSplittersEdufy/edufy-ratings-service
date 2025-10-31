package org.example.edufyratingsservice.entities;

import jakarta.persistence.*;
import org.example.edufyratingsservice.enums.MediaType;
import org.example.edufyratingsservice.enums.RatingType;

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

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private MediaType mediaType;

    @Column(length=25,nullable = false)
    private Long mediaId;



    public Rating(Long userId, RatingType ratingType, MediaType mediaType, Long mediaId) {
        this.userId = userId;
        this.ratingType = ratingType;
        this.mediaType = mediaType;
        this.mediaId = mediaId;
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

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", ratingType=" + ratingType +
                ", userId=" + userId +
                ", mediaType='" + mediaType +
                ", mediaId='" + mediaId +
                '}';
    }
}
