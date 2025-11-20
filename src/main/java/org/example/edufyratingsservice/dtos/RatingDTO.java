package org.example.edufyratingsservice.dtos;

import jakarta.validation.constraints.NotNull;
import org.example.edufyratingsservice.enums.MediaType;
import org.example.edufyratingsservice.enums.RatingType;

public class RatingDTO {
    private Long id;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Rating type is required")
    private RatingType ratingType;

    @NotNull(message = "Media type is required")
    private MediaType mediaType;

    @NotNull(message = "Media ID is required")
    private Long mediaId;


    public RatingDTO() {}

    public RatingDTO(Long userId, RatingType ratingType, RatingType rating, MediaType mediaType, Long mediaId) {
        this.userId = userId;
        this.ratingType = ratingType;
        this.mediaType = mediaType;
        this.mediaId = mediaId;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
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

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RatingDTO [userId=" + userId + ", ratingType=" + ratingType + ", mediaType=" + mediaType + ", mediaId=" + mediaId + "]";
    }
}
