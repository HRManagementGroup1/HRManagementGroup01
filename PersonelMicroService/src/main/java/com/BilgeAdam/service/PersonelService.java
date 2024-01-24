package com.BilgeAdam.service;


import com.BilgeAdam.dto.request.LoginPersonelRequestDto;
import com.BilgeAdam.dto.request.RegisterRequestDto;
import com.BilgeAdam.dto.response.RegisterResponseDto;
import com.BilgeAdam.exception.ErrorType;
import com.BilgeAdam.exception.PersonelManagerException;
import com.BilgeAdam.mapper.PersonelMapper;
import com.BilgeAdam.repository.PersonelRepository;
import com.BilgeAdam.repository.entity.Personel;
import com.BilgeAdam.utility.enums.ERole;
import com.BilgeAdam.utility.enums.EState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonelService {

    private final PersonelRepository personelRepository;

    public Boolean login(LoginPersonelRequestDto dto) {
        Optional<Personel> personel=personelRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (personel.isEmpty()){
            throw new PersonelManagerException(ErrorType.LOGIN_ERROR);
        }else {
            return true;
        }
    }
    // personel id bulup spending / advance service üzerinde çağırdık
    public Optional<Personel> findById(String id){
        return personelRepository.findById(id);
    }
    public RegisterResponseDto register(RegisterRequestDto dto) {
        Personel personel= PersonelMapper.INSTANCE.fromRegisterRequestToPersonel(dto);
        personel.setState(EState.PENDING);
        personel.setRole(ERole.PERSONEL);
        personelRepository.save(personel);
        return PersonelMapper.INSTANCE.fromPersonelToRegisterResponse(personel);
    }
}