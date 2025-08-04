package com.fiap.ms.usuario.adapters.out.repository.mapper;

import com.fiap.ms.usuario.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RestauranteEntityMapper {

    RestauranteEntity toRestauranteEntity(RestauranteDomain restauranteDomain);

    RestauranteDomain toRestauranteDomain(RestauranteEntity restauranteEntity);

}


