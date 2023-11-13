package com.devloc.managementsof.service.impl;


import com.devloc.managementsof.entity.Rol;
import com.devloc.managementsof.repository.IRolRepo;
import com.devloc.managementsof.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolRepo repo;

    @Override
    public Rol create(Rol entity) {
        return repo.save(entity);
    }

    @Override
    public Rol update(Rol entity) {
        return repo.save(entity);
    }

    @Override
    public List<Rol> getAll() {
        return repo.findAll();
    }

    @Override
    public Rol getOneById(Integer id) {
        Optional<Rol> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Rol();
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
