package za.ac.cput.domain;

import java.time.LocalDate;

public class Review {
    private String reviewId;
    private int rating;
    private String comments;
    private LocalDate reviewDate;




    public Review(String reviewId, int rating, String comments, LocalDate reviewDate) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comments = comments;
        this.reviewDate = reviewDate;
    }

    public String getReviewId() {
        return reviewId;
    }

    public int getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
