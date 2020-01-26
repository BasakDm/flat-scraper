package com.example.basak.springrenew.util.maper;

public interface Mapper<E, D> {

    E toEntity(D dto);

    D toDto(E entity);

}
