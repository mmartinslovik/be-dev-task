package com.example.productmanager.data.repository;

import com.example.productmanager.data.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * BaseRepository for common CRUD operations
 *
 * @param <E> Entity
 * @param <K> Key
 */
@Repository
public interface BaseRepository<E extends BaseEntity, K> extends CrudRepository<E, K> {

    <S extends E> S save(S entity);

    Iterable<E> findAll();
}
