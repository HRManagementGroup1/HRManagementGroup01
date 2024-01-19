package com.veysel.mapper;

import com.veysel.dto.request.UserCreateRequestDto;
import com.veysel.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserProfile fromCreateRequestToUser(UserCreateRequestDto dto);




}
