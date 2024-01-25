package com.BilgeAdam.service;


import com.BilgeAdam.dto.request.SpendingRequestDto;
import com.BilgeAdam.repository.SpendingRepository;
import com.BilgeAdam.repository.entity.Spending;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpendingService {
    private final SpendingRepository spendingRepository;

    public Optional<Spending> createSpending(SpendingRequestDto dto){

    }

}
