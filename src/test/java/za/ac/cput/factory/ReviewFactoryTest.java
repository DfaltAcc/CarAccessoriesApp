package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReviewFactoryTest {

    private static Review review = ReviewFactory.createReview(
            5,
            "These 18-inch rims are top-notch! They improved both the look and performance of my car.",
            LocalDate.of(2025, 5, 18)
    );

    @Test
    void createReview() {
        assertNotNull(review);
        assertEquals(5, review.getRating());
        assertEquals("These 18-inch rims are top-notch! They improved both the look and performance of my car.",
                review.getComments());
        assertEquals(LocalDate.of(2025, 5, 18), review.getReviewDate());
        System.out.println(review);
    }

}