package com.BilgeAdam.controller;


import com.BilgeAdam.dto.request.AdvanceRequestDto;
import com.BilgeAdam.repository.entity.Advance;
import com.BilgeAdam.service.AdvanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.BilgeAdam.constants.RestApiUrls.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(ADVANCE)
public class AdvanceController {
    private final AdvanceService advanceService;

    @PostMapping(CREATE)
    public ResponseEntity<Optional<Advance>> createAdvance(AdvanceRequestDto dto){
        return ResponseEntity.ok(advanceService.createAdvance(dto));
    }


}
