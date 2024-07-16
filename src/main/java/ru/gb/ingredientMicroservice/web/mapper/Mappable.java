package ru.gb.ingredientMicroservice.web.mapper;

import java.util.List;

/**
 * Интерфейс, который определяющий методы для создания DTO объектов
 * @param <E> - принимает на вход сущность
 * @param <D> - отдает объект DTO
 */
public interface Mappable<E,D> {
    D toDto(E entity);
    List<D> toDto(List<E> eList);

    E toEntity(D dto);
    List<E> toEntity(List<D> dList);

}
