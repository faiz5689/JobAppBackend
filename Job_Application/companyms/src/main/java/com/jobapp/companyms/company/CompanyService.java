package com.jobapp.companyms.company;

import com.jobapp.companyms.company.dto.ReviewMessage;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Long id, Company updatedCompany);

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean deleteCompany(Long id);

    void updateCompanyRating(ReviewMessage reviewMessage);
}
