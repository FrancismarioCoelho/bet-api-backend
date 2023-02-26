package br.com.betApi.application.shared.util;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static  <S, D> D mapTo(S source, D destClass) {
        BeanUtils.copyProperties(source, destClass);
        return destClass;
    }

    public static  <S, D> List<D> mapListTo(List<S> list, D destClass) {
        return list.stream()
                .map(s -> mapTo(s, destClass))
                .collect(Collectors.toList());
    }

    public static <D, T> Page<D> mapToPageable(Page<T> entities, D dtoClass) {
        return entities.map(t -> mapTo(t, dtoClass));
    }
}
