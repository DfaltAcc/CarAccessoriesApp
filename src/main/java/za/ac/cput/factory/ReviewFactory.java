package za.ac.cput.factory;
import za.ac.cput.domain.Review;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class ReviewFactory {
    public static Review createReview(int rating, String comments, LocalDate reviewDate){

        if (rating < 1 || rating > 5
                || Helper.isNullOrEmpty(comments)
                || reviewDate == null) {
            return null;
        }

        String reviewId = Helper.generateId();


        return new Review.Builder()
                .setRating(rating)
                .setComments(comments)
                .setReviewDate(reviewDate)
                .build();
    }
}
