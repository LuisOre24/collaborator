package com.devloc.managementsof.service.impl;


import com.devloc.managementsof.entity.AccountType;
import com.devloc.managementsof.repository.IAccountTypeRepo;
import com.devloc.managementsof.service.IAccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountTypeServiceImpl implements IAccountTypeService {

    @Autowired
    private IAccountTypeRepo repo;

    @Override
    public AccountType create(AccountType entity) {
        return repo.save(entity);
    }

    @Override
    public AccountType update(AccountType entity) {
        return repo.save(entity);
    }

    @Override
    public List<AccountType> getAll() {
        return repo.findAll();
    }

    @Override
    public AccountType getOneById(Integer id) {
        Optional<AccountType> op = repo.findById(id);
        return op.isPresent() ? op.get() : new AccountType();
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
