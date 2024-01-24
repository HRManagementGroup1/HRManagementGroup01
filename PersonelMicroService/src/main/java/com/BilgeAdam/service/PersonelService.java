package com.BilgeAdam.service;


import com.BilgeAdam.dto.request.LoginPersonelRequestDto;
import com.BilgeAdam.exception.ErrorType;
import com.BilgeAdam.exception.PersonelManagerException;
import com.BilgeAdam.repository.PersonelRepository;
import com.BilgeAdam.repository.entity.Personel;
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
}
