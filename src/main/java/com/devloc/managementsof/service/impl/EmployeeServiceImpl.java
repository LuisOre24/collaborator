package com.devloc.managementsof.service.impl;


import com.devloc.managementsof.entity.Employee;
import com.devloc.managementsof.repository.IEmployeeRepo;
import com.devloc.managementsof.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepo repo;

    @Override
    public Employee create(Employee entity) {
        return repo.save(entity);
    }

    @Override
    public Employee update(Employee entity) {
        return repo.save(entity);
    }

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    public Employee getOneById(Integer id) {

        Optional<Employee> optional = repo.findById(id);
        return optional.isPresent() ? optional.get() : new Employee();
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
