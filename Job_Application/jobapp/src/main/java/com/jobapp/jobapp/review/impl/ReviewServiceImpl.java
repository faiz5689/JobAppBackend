package com.jobapp.jobapp.review.impl;

import com.jobapp.jobapp.company.Company;
import com.jobapp.jobapp.company.CompanyRepository;
import com.jobapp.jobapp.review.Review;
import com.jobapp.jobapp.review.ReviewRepository;
import com.jobapp.jobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyRepository companyRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyRepository companyRepository) {
        this.reviewRepository = reviewRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyRepository.findById(companyId).orElse(null);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long id) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        return companyRepository.findById(companyId)
                .flatMap(company -> reviewRepository.findById(reviewId)
                        .filter(existingReview -> existingReview.getCompany().getId().equals(companyId))
                        .map(existingReview -> {
                            updatedReview.setId(reviewId);
                            updatedReview.setCompany(company);
                            reviewRepository.save(updatedReview);
                            return true;
                        }))
                .orElse(false);
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        return companyRepository.findById(companyId)
                .flatMap(company -> reviewRepository.findById(reviewId)
                    .filter(existingReview -> existingReview.getCompany().getId().equals(companyId))
                    .map(existingReview -> {
                        reviewRepository.deleteById(reviewId);
                        return true;
                })).orElse(false);
    }


}
