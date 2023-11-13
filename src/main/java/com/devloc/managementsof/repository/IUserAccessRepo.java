package com.devloc.managementsof.repository;


import com.devloc.managementsof.entity.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserAccessRepo extends JpaRepository<UserAccess, Integer> {

    public UserAccess findByUsername(String username);

}
