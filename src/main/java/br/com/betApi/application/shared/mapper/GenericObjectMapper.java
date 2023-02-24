package br.com.betApi.application.shared.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0.0
 * @Author: Luiz Augusto
 * @E-mail: luiz.develop@gmail.com
 * Do not change this class
 */

@Component
public class GenericObjectMapper {
    @Autowired
    ModelMapper modelMapper;

    public <S, D> D mapTo(S source, Class<D> destClass) {
        return this.modelMapper.map(source, destClass);
    }

    public <S, D> List<D> mapListTo(List<S> list, Class<D> destClass) {
        return list.stream()
                .map(s -> modelMapper.map(s, destClass))
                .collect(Collectors.toList());
    }

    public <D, T> Page<D> mapToPageable(Page<T> entities, Class<D> dtoClass) {
        return entities.map(objectEntity -> modelMapper.map(objectEntity, dtoClass));
    }
}
