package com.fiap.ms.usuario.adapters.in.controller.mapper;

import com.fiap.ms.usuario.application.core.domain.RestauranteDomain;
import com.fiap.ms.usuarioDomain.gen.model.AtualizarRestauranteRequestDto;
import com.fiap.ms.usuarioDomain.gen.model.RestauranteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RestauranteDtoMapper {

    @Mapping(target = "id", ignore = true)
    RestauranteDomain toRestauranteDomain(RestauranteDto restauranteDto);

    RestauranteDto toRestauranteDto(RestauranteDomain restauranteDomain);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    RestauranteDomain toRestauranteDomainUpdate(AtualizarRestauranteRequestDto atualizarDto);
}


