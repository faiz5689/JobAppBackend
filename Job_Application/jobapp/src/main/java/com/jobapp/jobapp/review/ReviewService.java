package com.jobapp.jobapp.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review getReview(Long companyId, Long id);

    boolean updateReview(Long companyId, Long id, Review updatedReview);

    boolean deleteReview(Long companyId, Long id);
}
