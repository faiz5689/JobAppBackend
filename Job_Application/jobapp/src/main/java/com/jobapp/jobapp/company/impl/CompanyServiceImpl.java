package com.jobapp.jobapp.company.impl;

import com.jobapp.jobapp.company.Company;
import com.jobapp.jobapp.company.CompanyRepository;
import com.jobapp.jobapp.company.CompanyService;
import com.jobapp.jobapp.job.Job;
import com.jobapp.jobapp.job.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private JobRepository jobRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, JobRepository jobRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Long id, Company updatedCompany) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setDescription(updatedCompany.getDescription());
            company.setName(updatedCompany.getName());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompany(Long id) {
        if(companyRepository.existsById(id)) {
            Optional<Company> companyOptional = companyRepository.findById(id);
            Company company = companyOptional.get();
            for (Job job: company.getJobs()) {
                jobRepository.deleteById(job.getId());
            }
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
