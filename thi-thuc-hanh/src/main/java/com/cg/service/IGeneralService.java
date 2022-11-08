package com.cg.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService <T>{
    Optional<T> findById(Long id);

    T save(T t);

    List<T> findAll();

    T getById(Long id);

    void deleteById(Long id);
}
