package za.ac.cput.domain;

import java.time.LocalDate;

public class Review {
    private String reviewId;
    private int rating;
    private String comments;
    private LocalDate reviewDate;

private Review(){}

    private Review(Builder builder){
    this.reviewId = builder.reviewId;
        this.rating = builder.rating;
        this.comments = builder.comments;
        this.reviewDate = builder.reviewDate;
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

    public static class Builder{
        private String reviewId;
        private int rating;
        private String comments;
        private LocalDate reviewDate;


        public Builder setReviewId (String reviewId){
            this.reviewId = reviewId;
            return this;
        }
        public Builder setRating (int rating){
            this.rating = rating;
            return this;
        }
        public Builder setComments (String comments){
            this.comments = comments;
            return this;
        }
        public Builder setReviewDate (LocalDate reviewDate){
            this.reviewDate = reviewDate;
            return this;
        }



        public Builder copy(Review review){
            this.reviewId = review.reviewId;
            this.rating = review.rating;
            this.comments = review.comments;
            this.reviewDate = review.reviewDate;
            return this;
        }
        public Review build(){
            return new Review(this);
        }
    }
}
