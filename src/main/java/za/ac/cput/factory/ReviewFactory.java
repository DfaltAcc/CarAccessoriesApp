package za.ac.cput.factory;
import za.ac.cput.domain.Review;

import java.time.LocalDate;

public class ReviewFactory {
    public static Review createReview(int rating, String comments, LocalDate reviewDate){

        return new Review.Builder()
                .setRating(rating)
                .setComments(comments)
                .setReviewDate(reviewDate)
                .build();
    }
}
