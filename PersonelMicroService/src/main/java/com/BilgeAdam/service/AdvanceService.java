package com.BilgeAdam.service;


import com.BilgeAdam.dto.request.AddAdvanceForPersonelRequestDto;
import com.BilgeAdam.dto.request.AdvanceRequestDto;
import com.BilgeAdam.exception.ErrorType;
import com.BilgeAdam.exception.PersonelManagerException;
import com.BilgeAdam.mapper.AdvanceMapper;
import com.BilgeAdam.repository.AdvanceRepository;
import com.BilgeAdam.repository.PersonelRepository;
import com.BilgeAdam.repository.entity.Advance;
import com.BilgeAdam.utility.enums.EState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvanceService {
    private final AdvanceRepository advanceRepository;
private final PersonelService personelService;
    public Optional<Advance> createAdvance(AdvanceRequestDto dto) {

        Advance advance = AdvanceMapper.INSTANCE.toAdvanceRequestDto(dto);
        dto.setState(EState.PENDING);
        dto.setPersonelId(personelService.findByPersonelId(dto.getPersonelId()));
        advanceRepository.save(advance);
    }

    public void addAdvanceForPersonel(AddAdvanceForPersonelRequestDto dto){
        if(!personelService.existsById(dto.getPersonelId()) || !PersonelService.isPersonel(dto.getPersonelId()))
            throw new PersonelManagerException(ErrorType.ADVANCE_NOT_FOUND);

    }
}
