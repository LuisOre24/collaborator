package com.devloc.managementsof.service.impl;


import com.devloc.managementsof.entity.Account;
import com.devloc.managementsof.repository.IAccountRepo;
import com.devloc.managementsof.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepo repo;

    @Override
    public Account create(Account entity) {
        return repo.save(entity);
    }

    @Override
    public Account update(Account entity) {
        return repo.save(entity);
    }

    @Override
    public List<Account> getAll() {
        return repo.findAll();
    }

    @Override
    public Account getOneById(Integer id) {
        Optional<Account> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Account();
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
