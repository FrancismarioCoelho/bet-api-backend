package br.com.betApi.domain.vo;

import java.util.List;

public interface IService <T> {

    T findById(Long id);
    List<T> findAll();
    T save(T t);
    T update(T t);
    void delete(Long id);
}
