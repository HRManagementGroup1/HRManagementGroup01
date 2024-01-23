package com.BilgeAdam.service;


import com.BilgeAdam.dto.request.AdvanceRequestDto;
import com.BilgeAdam.repository.AdvanceRepository;
import com.BilgeAdam.repository.entity.Advance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvanceService {
    private final AdvanceRepository advanceRepository;
    public Optional<Advance> createAdvance(AdvanceRequestDto dto){

    }
}
