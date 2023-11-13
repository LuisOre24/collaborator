package com.devloc.managementsof.service.impl;


import com.devloc.managementsof.entity.Company;
import com.devloc.managementsof.repository.ICompanyRepo;
import com.devloc.managementsof.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ICompanyRepo repo;

    @Override
    public Company create(Company entity) {
        return repo.save(entity);
    }

    @Override
    public Company update(Company entity) {
        return repo.save(entity);
    }

    @Override
    public List<Company> getAll() {
        return repo.findAll();
    }

    @Override
    public Company getOneById(Integer id) {

        Optional<Company> optional = repo.findById(id);
        return optional.isPresent() ? optional.get() :  new Company();
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
