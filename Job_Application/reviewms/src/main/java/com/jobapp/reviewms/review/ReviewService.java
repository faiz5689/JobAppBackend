package com.jobapp.reviewms.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review getReview(Long id);

    boolean updateReview(Long id, Review updatedReview);

    boolean deleteReview(Long id);
}
