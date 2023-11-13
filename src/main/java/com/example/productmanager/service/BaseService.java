package com.example.productmanager.service;

import java.util.List;

/**
 * BaseService for common CRUD operations
 *
 * @param <E> Entity
 */
public interface BaseService<E> {

    E save(E entity);

    List<E> findAll();
}
