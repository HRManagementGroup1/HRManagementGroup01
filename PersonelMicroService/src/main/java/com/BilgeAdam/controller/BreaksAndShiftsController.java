package com.BilgeAdam.controller;

import com.BilgeAdam.dto.request.BreaksRequestDto;
import com.BilgeAdam.dto.request.ShiftRequestDto;
import com.BilgeAdam.repository.entity.BreaksAndShifts;
import com.BilgeAdam.service.BreaksAndShiftsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.BilgeAdam.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(BREAKSANDSHIFTS)
public class BreaksAndShiftsController {
    private final BreaksAndShiftsService breaksAndShiftsService;
    @PostMapping(CREATEBREAKS)
    public ResponseEntity<Optional<BreaksAndShifts>> createBreaks(BreaksRequestDto dto){
        return ResponseEntity.ok(breaksAndShiftsService.createBreaks(dto));
    }
    @PostMapping(CREATESHIFTS)
    public ResponseEntity<Optional<BreaksAndShifts>> createBreaks(ShiftRequestDto dto){
        return ResponseEntity.ok(breaksAndShiftsService.createShifts(dto));
    }

}
