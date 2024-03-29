package com.BilgeAdam.mapper;

import com.BilgeAdam.dto.request.AdvanceRequestDto;
import com.BilgeAdam.repository.entity.Advance;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface AdvanceMapper {
    AdvanceMapper INSTANCE = Mappers.getMapper(AdvanceMapper.class);

    Advance toAdvance(final AdvanceRequestDto advance);

}
