package com.BilgeAdam.service;


import com.BilgeAdam.config.CloudinaryConfig;
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
    private final CloudinaryConfig cloudinaryConfig;

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

    public Optional<Personel>findPersonelByTCNO(String TCNO){
        return personelRepository.findPersonelByTCNO(TCNO);
    }

    public Optional<Personel>findPersonelByNameAndSurname(String name,String surname){
        return personelRepository.findPersonelByNameAndSurname(name,surname);
    }


    public RegisterResponseDto register(RegisterRequestDto dto) {
        Personel personel= Personel.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .TCNO(dto.getTCNO())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .photo(cloudinaryConfig.toTurnStringAvatar(dto.getPhoto()))
                .company(dto.getCompany())
                .dateOfBirth(dto.getDateOfBirth())
                .hiringDate(dto.getHiringDate())
                .department(dto.getDepartment())
                .address(dto.getAddress())
                .title(dto.getTitle())
                .salary(dto.getSalary())
                .role(ERole.PERSONEL)
                .state(EState.PENDING)
                .remainingDaysOff(dto.getRemainingDaysOff())
                .build();
        personelRepository.save(personel);
        return PersonelMapper.INSTANCE.fromPersonelToRegisterResponse(personel);
    }

}



