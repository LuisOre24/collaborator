package com.devloc.managementsof.service.impl;


import com.devloc.managementsof.entity.Subsidiary;
import com.devloc.managementsof.repository.ISubsidiaryRepo;
import com.devloc.managementsof.service.ISubsidiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubsidiaryServiceImpl implements ISubsidiaryService {

    @Autowired
    private ISubsidiaryRepo repo;
    @Override
    public Subsidiary create(Subsidiary entity) {
        return repo.save(entity);
    }

    @Override
    public Subsidiary update(Subsidiary entity) {
        return repo.save(entity);
    }

    @Override
    public List<Subsidiary> getAll() {
        return repo.findAll();
    }

    @Override
    public Subsidiary getOneById(Integer id) {
        Optional<Subsidiary> optional = repo.findById(id);
        return optional.isPresent() ? optional.get() : new Subsidiary();
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
