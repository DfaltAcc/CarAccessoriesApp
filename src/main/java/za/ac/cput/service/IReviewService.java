package za.ac.cput.service;

import za.ac.cput.domain.Review;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IReviewService extends IService<Review, String> {

    Review findReviewByReviewId(String reviewId);

    Optional<Review> findReviewByReviewDate(LocalDate reviewDate);

    List<Review> findAllByRating(int rating);
}
