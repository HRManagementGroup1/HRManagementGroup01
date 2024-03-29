package com.BilgeAdam.service;


import com.BilgeAdam.dto.request.AddAdvanceForPersonelRequestDto;
import com.BilgeAdam.dto.request.AdvanceRequestDto;
import com.BilgeAdam.exception.ErrorType;
import com.BilgeAdam.exception.PersonelManagerException;
import com.BilgeAdam.mapper.AdvanceMapper;
import com.BilgeAdam.repository.AdvanceRepository;
import com.BilgeAdam.repository.PersonelRepository;
import com.BilgeAdam.repository.entity.Advance;
import com.BilgeAdam.repository.entity.Personel;
import com.BilgeAdam.utility.enums.EState;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvanceService {
    private final AdvanceRepository advanceRepository;

private final PersonelService personelService;
   /* public Optional<Advance> createAdvance(AdvanceRequestDto dto) {

        Advance advance = AdvanceMapper.INSTANCE.toAdvanceRequestDto(dto);
        dto.setState(EState.PENDING);
        dto.setPersonelId(personelService.findByPersonelId(dto.getPersonelId()));
        advanceRepository.save(advance);
=========
    public Optional<Advance> createAdvance(AdvanceRequestDto dto){
        return Optional.empty();
>>>>>>>>> Temporary merge branch 2
    }

    public void addAdvanceForPersonel(AddAdvanceForPersonelRequestDto dto){
        if(!personelService.existsById(dto.getPersonelId()) || !PersonelService.isPersonel(dto.getPersonelId()))
            throw new PersonelManagerException(ErrorType.ADVANCE_NOT_FOUND);

    }*/

    public Optional<Advance> createAdvance(AdvanceRequestDto advanceRequestDto) {


        // SpendingRequestDto'dan Spending entity'sine dönüştürme
        Advance advance = AdvanceMapper.INSTANCE.toAdvance(advanceRequestDto);

        // Personel entity'sini çekme
        String personelId = advanceRequestDto.getPersonelId();
        Optional<Personel> personel = personelService.findById(personelId);

        // Eğer personel bulunamazsa, gerekli hata işlemlerini yapabilirsiniz.
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }

        // Spending entity'sine personel bilgisini set etme
        advance.setPersonelId(personelId);

        // Diğer işlemleri gerçekleştirme ve avans kaydetme
        return Optional.of(advanceRepository.save(advance));
    }



}
