package com.BilgeAdam.controller;

import com.furkan.constants.RestApiUrls;
import com.furkan.dto.request.SpendingRequestDto;
import com.furkan.repository.entity.Spending;
import com.furkan.service.SpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.furkan.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(SPENDING)
public class SpendingController {
    private final SpendingService spendingService;

    @PostMapping(RestApiUrls.CREATE)
    public ResponseEntity<Optional<Spending>> createSpending(SpendingRequestDto dto){
        return ResponseEntity.ok(spendingService.createSpending(dto));
    }


}
