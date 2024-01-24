package com.BilgeAdam.mapper;

import com.BilgeAdam.dto.request.PermissionRequestDto;
import com.BilgeAdam.dto.request.SpendingRequestDto;
import com.BilgeAdam.repository.entity.Permissions;
import com.BilgeAdam.repository.entity.Spending;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface PermissionsMapper {

  PermissionsMapper INSTANCE = Mappers.getMapper(PermissionsMapper.class);
    Permissions toPermissions(final PermissionRequestDto permissions);
}
