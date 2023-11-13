package com.devloc.managementsof.service.impl;


import com.devloc.managementsof.entity.Position;
import com.devloc.managementsof.repository.IPositionRepo;
import com.devloc.managementsof.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private IPositionRepo repo;

    @Override
    public Position create(Position entity) {
        return repo.save(entity);
    }

    @Override
    public Position update(Position entity) {
        return repo.save(entity);
    }

    @Override
    public List<Position> getAll() {
        return repo.findAll();
    }

    @Override
    public Position getOneById(Integer id) {
        Optional<Position> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Position();
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
