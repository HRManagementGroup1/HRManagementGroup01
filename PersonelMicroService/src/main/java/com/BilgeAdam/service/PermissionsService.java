package com.BilgeAdam.service;

import com.BilgeAdam.dto.request.AdvanceRequestDto;
import com.BilgeAdam.dto.request.PermissionRequestDto;
import com.BilgeAdam.exception.ErrorType;
import com.BilgeAdam.exception.PersonelManagerException;
import com.BilgeAdam.mapper.AdvanceMapper;
import com.BilgeAdam.mapper.PermissionsMapper;
import com.BilgeAdam.repository.PermissionsRepository;
import com.BilgeAdam.repository.entity.Advance;
import com.BilgeAdam.repository.entity.Permissions;
import com.BilgeAdam.repository.entity.Personel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermissionsService {
    private final PermissionsRepository permissionsRepository;
    private final PersonelService personelService;

    public Optional<Permissions> createPermissions(PermissionRequestDto permissionRequestDto) {

        Permissions permissions = PermissionsMapper.INSTANCE.toPermissions(permissionRequestDto);

        String personelId = permissionRequestDto.getPersonelId();
        Optional<Personel> personel = personelService.findById(personelId);
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        permissions.setPersonelId(personelId);
        return Optional.of(permissionsRepository.save(permissions));
    }
}
