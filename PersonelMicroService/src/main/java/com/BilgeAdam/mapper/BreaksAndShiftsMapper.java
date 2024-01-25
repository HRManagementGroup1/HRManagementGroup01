package com.BilgeAdam.mapper;

import com.BilgeAdam.dto.request.BreaksRequestDto;
import com.BilgeAdam.dto.request.ShiftRequestDto;
import com.BilgeAdam.repository.entity.BreaksAndShifts;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BreaksAndShiftsMapper {
    BreaksAndShiftsMapper INSTANCE= Mappers.getMapper(BreaksAndShiftsMapper.class);
    BreaksAndShifts toBreaks(final BreaksRequestDto breaksRequestDto);
    BreaksAndShifts toShifts(final ShiftRequestDto shift);
}
