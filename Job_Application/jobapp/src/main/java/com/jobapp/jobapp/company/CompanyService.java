package com.jobapp.jobapp.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Long id, Company updatedCompany);

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean deleteCompany(Long id);
}
