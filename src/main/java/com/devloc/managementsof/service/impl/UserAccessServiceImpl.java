package com.devloc.managementsof.service.impl;

import com.devloc.managementsof.entity.Rol;
import com.devloc.managementsof.entity.UserAccess;
import com.devloc.managementsof.repository.IUserAccessRepo;
import com.devloc.managementsof.service.IUserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAccessServiceImpl implements UserDetailsService ,IUserAccessService{

    @Autowired
    private IUserAccessRepo userAccessRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        UserAccess userAccess = userAccessRepo.findByUsername(username);
        if(userAccess == null){
            throw new UsernameNotFoundException("not found" + username);
        }

        return new User(userAccess.getUsername(),userAccess.getPassword(), mapearAutoridadesRoles(userAccess.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public UserAccess create(UserAccess entity) {
        UserAccess userAccess = new UserAccess();
        try {
            userAccess.setEmployee(entity.getEmployee());
            userAccess.setUsername(entity.getUsername());
            userAccess.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
            userAccess.setRoles(entity.getRoles());
            userAccess.setEnabled(true);
        }
        catch (Exception e){
            throw e;
        }
        return userAccessRepo.save(userAccess);
    }

    @Override
    public UserAccess update(UserAccess entity) {
        return userAccessRepo.save(entity);
    }

    @Override
    public List<UserAccess> getAll() {
        return userAccessRepo.findAll();
    }

    @Override
    public UserAccess getOneById(Integer id) {
        Optional<UserAccess> op = userAccessRepo.findById(id);
        return op.isPresent() ? op.get() : new UserAccess();
    }

    @Override
    public void deleteById(Integer id) {
        userAccessRepo.deleteById(id);
    }
}