package com.BilgeAdam.service;


import com.BilgeAdam.dto.request.LoginPersonelRequestDto;
import com.BilgeAdam.exception.ErrorType;
import com.BilgeAdam.exception.PersonelManagerException;
import com.BilgeAdam.repository.PersonelRepository;
import com.BilgeAdam.repository.entity.Personel;
import com.BilgeAdam.utility.enums.ERole;
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
}
