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
<<<<<<<<< Temporary merge branch 1
=========
import com.BilgeAdam.utility.enums.EState;
>>>>>>>>> Temporary merge branch 2
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonelService {


    private final PersonelRepository personelRepository;

    public Boolean login(LoginPersonelRequestDto dto) {
        Optional<Personel> personel=personelRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (personel.isEmpty()||personel.get().getRole()== ERole.DISMISSED){
           throw new PersonelManagerException(ErrorType.LOGIN_ERROR);
        }else {
            return true;

        }
    }
<<<<<<<<< Temporary merge branch 1
        /*  public boolean existsById(String personelId){

        return personelRepository.existsById(personelId);
          }
          public String findByPersonelId(String personelId){
            return personelRepository.findByPersonelId(personelId);
          }
    public void register(RegisterPersonelRequestDto dto, ERole callerRole) {
        // Register işlemi
        if (callerRole != ERole.ROLE_MANAGER) {
            throw new PersonelManagerException(ErrorType.UNAUTHORIZED_ACCESS);
        }

        Optional<Personel> existingPersonel = personelRepository.findOptionalByEmail(dto.getEmail());
        if (existingPersonel.isPresent()) {
            throw new PersonelManagerException(ErrorType.REGISTRATION_ERROR);
        } else {
            // Yeni personel oluştur
            Personel newPersonel = new Personel();
            newPersonel.setEmail(dto.getEmail());
            newPersonel.setPassword(dto.getPassword());

            // Personeli kaydet
            personelRepository.save(newPersonel);
        }
    }*/
=========

    public RegisterResponseDto register(RegisterRequestDto dto) {
        Personel personel= PersonelMapper.INSTANCE.fromRegisterRequestToPersonel(dto);
        personel.setState(EState.PENDING);
        personel.setRole(ERole.PERSONEL);
        personelRepository.save(personel);
        return PersonelMapper.INSTANCE.fromPersonelToRegisterResponse(personel);
    }
>>>>>>>>> Temporary merge branch 2
}
