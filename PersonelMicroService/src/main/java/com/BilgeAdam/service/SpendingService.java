package com.BilgeAdam.service;


import com.BilgeAdam.dto.request.SpendingRequestDto;
import com.BilgeAdam.exception.ErrorType;
import com.BilgeAdam.exception.PersonelManagerException;
import com.BilgeAdam.mapper.SpendingMapper;
import com.BilgeAdam.repository.SpendingRepository;
import com.BilgeAdam.repository.entity.Personel;
import com.BilgeAdam.repository.entity.Spending;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpendingService {
    private final SpendingRepository spendingRepository;
    private final PersonelService personelService;

<<<<<<< HEAD
    public Optional<Spending> createSpending(SpendingRequestDto dto){
        return Optional.empty();
=======
    public Optional<Spending> createSpending(SpendingRequestDto spendingRequestDto) {

        // SpendingRequestDto'dan Spending entity'sine dönüştürme
        Spending spending = SpendingMapper.INSTANCE.toSpending(spendingRequestDto);

        // Personel entity'sini çekme
        String personelId = spendingRequestDto.getPersonelId();
        Optional<Personel> personel = personelService.findById(personelId);

        // Eğer personel bulunamazsa, gerekli hata işlemlerini yapabilirsiniz.
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }

        // Spending entity'sine personel bilgisini set etme
        spending.setPersonelId(personelId);

        // Diğer işlemleri gerçekleştirme ve harcamayı kaydetme
        // ...
        return Optional.of(spendingRepository.save(spending));
>>>>>>> f66a1401428ac3a2a4f368e1d31dfa36406ef3cd
    }

}
