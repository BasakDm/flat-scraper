package com.example.basak.springrenew.util.maper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractMapper<E, D> implements Mapper<E, D> {

    protected ModelMapper mapper;

    Converter<D, E> toEntityConverter() {
        return context -> {
            D source = context.getSource();
            E destination = context.getDestination();
            mapSpecificDtoFields(source, destination);
            return context.getDestination();
        };
    }

    Converter<E, D> toDtoConverter() {
        return context -> {
            E source = context.getSource();
            D destination = context.getDestination();
            mapSpecificEntityFields(source, destination);
            return context.getDestination();
        };
    }

    void mapSpecificEntityFields(E source, D destination) {
        //Override if need specific mapping
    }

    void mapSpecificDtoFields(D source, E destination) {
        //Override if need specific mapping
    }

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

}
