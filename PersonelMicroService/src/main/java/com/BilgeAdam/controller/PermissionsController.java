package com.BilgeAdam.controller;

import com.BilgeAdam.constants.RestApiUrls;
import com.BilgeAdam.dto.request.PermissionRequestDto;
import com.BilgeAdam.dto.request.SpendingRequestDto;
import com.BilgeAdam.repository.entity.Permissions;
import com.BilgeAdam.repository.entity.Spending;
import com.BilgeAdam.service.PermissionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.BilgeAdam.constants.RestApiUrls.PERMISSIONS;

@RestController
@RequiredArgsConstructor
@RequestMapping(PERMISSIONS)
public class PermissionsController {
    private final PermissionsService permissionsService;

    @PostMapping(RestApiUrls.CREATE)
    public ResponseEntity<Optional<Permissions>> createPermissions(PermissionRequestDto dto){
        return ResponseEntity.ok(permissionsService.createPermissions(dto));
    }

}
