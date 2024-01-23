package com.BilgeAdam.controller;


import com.BilgeAdam.dto.request.LoginPersonelRequestDto;
import com.BilgeAdam.service.PersonelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.BilgeAdam.constants.RestApiUrls.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(PERSONEL)
public class PersonelController {
    private final PersonelService personelService;
    @PostMapping(LOGIN)
public ResponseEntity<Boolean> login(LoginPersonelRequestDto dto){
        return ResponseEntity.ok(personelService.login(dto));
    }

}
