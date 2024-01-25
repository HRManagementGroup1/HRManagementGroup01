package com.BilgeAdam.mapper;

import com.BilgeAdam.dto.request.ItemsRequestDto;
import com.BilgeAdam.dto.response.ItemsResponseDto;
import com.BilgeAdam.repository.entity.Items;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ItemsMapper {
    ItemsMapper INSTANCE = Mappers.getMapper(ItemsMapper.class);
    Items fromCreateItemsRequestDto(ItemsRequestDto dto);
    ItemsResponseDto fromItemsToCreateItemsResponse(Items items);
}
