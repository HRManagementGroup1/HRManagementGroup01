package com.BilgeAdam.mapper;


import com.BilgeAdam.dto.request.AdvanceRequestDto;
import com.BilgeAdam.dto.request.SpendingRequestDto;
import com.BilgeAdam.repository.entity.Spending;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SpendingMapper {
    SpendingMapper INSTANCE = Mappers.getMapper(SpendingMapper.class);
    SpendingRequestDto toSpendingRequestDto(final Spending spending);
    AdvanceRequestDto toAdvanceRequestDto(final Spending spending);

}
