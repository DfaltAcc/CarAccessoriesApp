package za.ac.cput.repository.Impl;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Review;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review , String> {
    Review findReviewByReviewId(String reviewId);

    Optional<Review> findReviewByReviewDate(LocalDate reviewDate);

    List<Review> findAllByRating(int rating);
}
