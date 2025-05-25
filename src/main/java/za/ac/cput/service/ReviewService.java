package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.Impl.ReviewRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ReviewService implements IReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public  Review findReviewByReviewId(String reviewId){
        return reviewRepository.findReviewByReviewId(reviewId);
    }

    @Override
    public Optional<Review> findReviewByReviewDate(LocalDate reviewDate){
        return reviewRepository.findReviewByReviewDate(reviewDate);
    }

    @Override
    public List<Review> findAllByRating(int rating){
        return reviewRepository.findAllByRating(rating);
    }

    @Override
    public Review save(Review review){
        return reviewRepository.save(review);
    }
    @Override
    public Review read(String reviewId){
        return reviewRepository.findReviewByReviewId(reviewId);
    }

}
