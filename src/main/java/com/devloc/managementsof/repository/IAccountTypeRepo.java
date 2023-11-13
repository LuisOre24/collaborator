package com.devloc.managementsof.repository;

import com.devloc.managementsof.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountTypeRepo extends JpaRepository<AccountType,Integer> {
}
