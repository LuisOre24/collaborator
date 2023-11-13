package com.devloc.managementsof.service.impl;


import com.devloc.managementsof.entity.WorkArea;
import com.devloc.managementsof.repository.IWorkAreaRepo;
import com.devloc.managementsof.service.IWorkAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkAreaServiceImpl implements IWorkAreaService {

    @Autowired
    private IWorkAreaRepo repo;


    @Override
    public WorkArea create(WorkArea entity) {
        return repo.save(entity);
    }

    @Override
    public WorkArea update(WorkArea entity) {
        return repo.save(entity);
    }

    @Override
    public List<WorkArea> getAll() {
        return repo.findAll();
    }

    @Override
    public WorkArea getOneById(Integer id) {
        Optional<WorkArea> optional = repo.findById(id);
        return optional.isPresent() ? optional.get() : new WorkArea();
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
