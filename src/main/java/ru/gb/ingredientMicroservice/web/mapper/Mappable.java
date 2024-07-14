package ru.gb.ingredientMicroservice.web.mapper;

import java.util.List;

public interface Mappable<E,D> {
    D toDto(E entity);
    List<D> toDto(List<E> eList);

    E toEntity(D dto);
    List<E> toEntity(List<D> dList);

}
