package com.example.productmanager.service;

import com.example.productmanager.data.model.BaseEntity;
import com.example.productmanager.data.repository.BaseRepository;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class BaseServiceImpl<E extends BaseEntity, K> implements BaseService<E> {

    private final BaseRepository<E, K> repository;
    private final Validator validator;

    @Autowired
    protected BaseServiceImpl(BaseRepository<E, K> repository, Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    @Transactional
    public E save(E entity) {
        var violations = validator.validate(entity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        return repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() {
        return (List<E>) repository.findAll();
    }
}
