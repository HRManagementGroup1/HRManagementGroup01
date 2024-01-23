package com.BilgeAdam.controller;

import com.BilgeAdam.constants.RestApiUrls;
import com.BilgeAdam.dto.request.SpendingRequestDto;
import com.BilgeAdam.repository.entity.Spending;
import com.BilgeAdam.service.SpendingService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.BilgeAdam.constants.RestApiUrls.SPENDING;

@RestController
@RequiredArgsConstructor
@RequestMapping(SPENDING)
public class SpendingController {
    private final SpendingService spendingService;
/*
    @PostMapping(RestApiUrls.CREATE)
    public ResponseEntity<Optional<Spending>> createSpending(SpendingRequestDto dto){
        return ResponseEntity.ok(spendingService.createSpending(dto));
    }

*/
}
