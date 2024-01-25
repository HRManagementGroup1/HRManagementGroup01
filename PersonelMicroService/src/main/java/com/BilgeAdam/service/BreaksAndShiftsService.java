package com.BilgeAdam.service;

import com.BilgeAdam.dto.request.BreaksRequestDto;
import com.BilgeAdam.dto.request.PermissionRequestDto;
import com.BilgeAdam.dto.request.ShiftRequestDto;
import com.BilgeAdam.exception.ErrorType;
import com.BilgeAdam.exception.PersonelManagerException;
import com.BilgeAdam.mapper.BreaksAndShiftsMapper;
import com.BilgeAdam.mapper.PermissionsMapper;
import com.BilgeAdam.repository.BreaksAndShiftsRepository;
import com.BilgeAdam.repository.entity.BreaksAndShifts;
import com.BilgeAdam.repository.entity.Permissions;
import com.BilgeAdam.repository.entity.Personel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BreaksAndShiftsService {
    private final BreaksAndShiftsRepository breaksAndShiftsRepository;
    private final PersonelService personelService;
    public Optional<BreaksAndShifts> createBreaks(BreaksRequestDto breaksRequestDto) {

        BreaksAndShifts breaksAndShifts = BreaksAndShiftsMapper.INSTANCE.toBreaks(breaksRequestDto);

        String personelId = breaksRequestDto.getPersonelId();
        Optional<Personel> personel = personelService.findById(personelId);
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }

        breaksAndShifts.setPersonelId(personelId);
        return Optional.of(breaksAndShiftsRepository.save(breaksAndShifts));
    }
    public Optional<BreaksAndShifts> createShifts(ShiftRequestDto shiftRequestDto) {

        BreaksAndShifts breaksAndShifts = BreaksAndShiftsMapper.INSTANCE.toShifts(shiftRequestDto);

        String personelId = shiftRequestDto.getPersonelId();
        Optional<Personel> personel = personelService.findById(personelId);
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }

        breaksAndShifts.setPersonelId(personelId);
        return Optional.of(breaksAndShiftsRepository.save(breaksAndShifts));
    }

}
