package com.BilgeAdam.controller;


import com.BilgeAdam.dto.request.LoginPersonelRequestDto;
import com.BilgeAdam.dto.request.RegisterRequestDto;
import com.BilgeAdam.dto.response.RegisterResponseDto;
import com.BilgeAdam.service.PersonelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.BilgeAdam.constants.RestApiUrls.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(PERSONEL)
public class PersonelController {
    private final PersonelService personelService;

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(LoginPersonelRequestDto dto) {
        return ResponseEntity.ok(personelService.login(dto));
    }


    /**
     * Gerekli Methodlar belirlecenek ve AzurDevops a öncelikle eklenilecek.LÜTFEN DİKKAT EDELİM AZURE DEVOPS KULLANALIM
     */

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto){
        return ResponseEntity.ok(personelService.register(dto));
    }

}
