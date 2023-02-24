package br.com.betApi.domain.vo;

import br.com.betApi.application.shared.dto.FilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService <T> {

    T findById(Long id);
    Page<T> findAll(FilterDto filterDto, Pageable pageable);
    T save(T t);
    T update(T t);
    void delete(Long id);
}
