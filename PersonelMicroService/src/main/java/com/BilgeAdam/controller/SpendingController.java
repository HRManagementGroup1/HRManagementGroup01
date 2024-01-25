package com.BilgeAdam.controller;

<<<<<<< HEAD
=======

>>>>>>> f66a1401428ac3a2a4f368e1d31dfa36406ef3cd
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

<<<<<<< HEAD
import static com.BilgeAdam.constants.RestApiUrls.*;
=======
import static com.BilgeAdam.constants.RestApiUrls.SPENDING;

>>>>>>> f66a1401428ac3a2a4f368e1d31dfa36406ef3cd

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
