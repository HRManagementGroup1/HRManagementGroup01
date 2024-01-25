package com.BilgeAdam.mapper;

import com.BilgeAdam.dto.request.RegisterRequestDto;
import com.BilgeAdam.dto.response.RegisterResponseDto;
import com.BilgeAdam.repository.entity.Personel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface PersonelMapper {
    PersonelMapper INSTANCE = Mappers.getMapper(PersonelMapper.class);

    /**
     * MultiPart files Mapper ile Gönderilemiyor..
     * @param personel
     * @return
     */
//    Personel fromRegisterRequestToPersonel(RegisterRequestDto dto);

    RegisterResponseDto fromPersonelToRegisterResponse(Personel personel);
}
