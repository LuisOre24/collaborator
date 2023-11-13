package com.devloc.managementsof.service;

import java.util.List;

public interface ICRUD<T> {

    T create (T entity);
    T update (T entity);
    List<T> getAll();
    T getOneById(Integer id);
    void deleteById(Integer id);


}
