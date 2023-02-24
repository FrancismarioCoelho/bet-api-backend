package br.com.betApi.domain.vo;

import br.com.betApi.application.shared.dto.FilterDto;
import org.springframework.data.domain.Page;

public interface IController<T> {


    T findById(Integer id);
    Page<T> findAll(FilterDto filterDto);
    T save(T t);
    T update(T t);
    void delete(Integer id);
}
