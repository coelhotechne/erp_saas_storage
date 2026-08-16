package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.baseClass.mapper;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GenericMapper <E,R,Q>{
    E toEntity(Q request);
    R toResponse(E entity);

    default List<R>toResponseList(List<E>entities){return entities.stream().map(this::toResponse).toList();}
}
